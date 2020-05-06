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

import src.bigfood.tabl.database;
import src.bigfoodlog.logUser;
import src.sql.Discount;

@WebServlet(urlPatterns = { "/discounts"})
public class Discounts extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public Discounts() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   HttpSession session = request.getSession();
	   Connection conn =  logUser.getStoredConnection(session);
	   String errorString = null;
       List<database> list = null;
       
           try {
			list = Discount.infodiscount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
          
	   request.setAttribute("error", errorString);
	   request.setAttribute("discounts", list);

	   
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/DiscountsView.jsp");
        
       dispatcher.forward(request, response);
            
   }
   }