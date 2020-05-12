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
	   String input = (String) request.getParameter("input");
	   String scann = (String) request.getParameter("scann");
	   String cod_id = (String) request.getParameter("cod_id");
	   HttpSession session = request.getSession();
	   Connection conn = logUser.getStoredConnection(session);
	   System.out.println("cod_id: " + cod_id);
	   
	   
	   if (cod_id != null) {
		   Integer cod_id1 = Integer.parseInt(cod_id);
		   Float discount = Float.parseFloat(input);
		   Float olddiscount=null;
		   try {
			   olddiscount = Discount.Search(cod_id1, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   
		   if (olddiscount != null & discount != null ) {
		   Float discount1=discount+olddiscount;
		   try {
				Discount.ADD(discount1, cod_id1, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   try {
			Discount.Dhistory(conn, cod_id1, discount, discount1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			   request.setAttribute("foto", "https://komip.msk.ru/media/k2/categories/12.jpg");
			   
		   }
		   else {request.setAttribute("foto", "https://static9.depositphotos.com/1431107/1108/i/950/depositphotos_11085415-stock-photo-error-icon.jpg"); } 
		   
		   doGet(request, response);
	   }
	   
		   
	   else if (scann != null) {
		   System.out.println("Start " + scann);
		   int id = 1 +  (int) (Math.random()*3);
			System.out.println("Math.random " + id);
		   String errorString = null;
		   List<database> list = null;
	       try {
			list = Findcod.findcod(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
        System.out.println("surname - " + list.get(0).getsurname());
        request.setAttribute("errorString", errorString);
        request.setAttribute("cod_id", list.get(0).cod_id());
        request.setAttribute("foto", list.get(0).getfoto());
        request.setAttribute("fio", list.get(0).getsurname() + " " + list.get(0).getfirst_name() + " " + list.get(0).getotchestvo());
        request.setAttribute("otdel", list.get(0).getotdel());
        request.setAttribute("position", list.get(0).getposition());
        
//        request.setAttribute("database", list);
   }
	    
       doGet(request, response);
   }
}