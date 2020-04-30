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
import src.sql.Findcod;


@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public HomeServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/homeView.jsp");
        
       dispatcher.forward(request, response);
       
       
        
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException { 
	   String discount = (String) request.getParameter("input");
	   String scann = (String) request.getParameter("scann");
	   
	   if (discount != null) {
		   System.out.println(discount);
		   request.setAttribute("foto", "https://komip.msk.ru/media/k2/categories/12.jpg");
		   doGet(request, response);
	   }
	   else if (scann != null) {
		   System.out.println("Start " + scann);
		   int cod_id = 1 +  (int) (Math.random()*3);
			System.out.println("Math.random " + cod_id);
			HttpSession session = request.getSession();
	   Connection conn = logUser.getStoredConnection(session);
		   String errorString = null;
		   List<database> list = null;
	       try {
			list = Findcod.findcod(conn, cod_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        System.out.println("surname - " + list.get(0).getsurname());
        request.setAttribute("errorString", errorString);
        request.setAttribute("foto", list.get(0).getfoto());
        request.setAttribute("fio", list.get(0).getsurname() + " " + list.get(0).getfirst_name() + " " + list.get(0).getotchestvo());
        request.setAttribute("otdel", list.get(0).getotdel());
        request.setAttribute("position", list.get(0).getposition());
        
//        request.setAttribute("database", list);
   }
	    
       doGet(request, response);
   }
}