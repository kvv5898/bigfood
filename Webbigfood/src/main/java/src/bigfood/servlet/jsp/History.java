package src.bigfood.servlet.jsp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.bigfood.tabl.Hdiscounts;
import src.bigfoodlog.logUser;
import src.sql.Discount;

@WebServlet(urlPatterns = { "/hdiscounts"})
public class History extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public History() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   HttpSession session = request.getSession();
	   Connection conn =  logUser.getStoredConnection(session);
	   String errorString = null;
       List<Hdiscounts> list = null;
       
           try {
			list = Discount.infohistory(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
          
	   request.setAttribute("error", errorString);
	   request.setAttribute("history", list);

	   
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/hdiscounts.jsp");
        
       dispatcher.forward(request, response);
            
   }
   }