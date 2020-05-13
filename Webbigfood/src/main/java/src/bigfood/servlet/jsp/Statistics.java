package src.bigfood.servlet.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.bigfood.tabl.Hdiscounts;
import src.bigfood.tabl.database;
import src.bigfoodlog.logUser;
import src.sql.Discount;

@WebServlet(urlPatterns = { "/statistics" })
public class Statistics extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Statistics() {
        super();
    }

	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   System.out.println("Start statistics");
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/statistics.jsp");
	        
	       dispatcher.forward(request, response);    
	   }
	 
	   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException { 
		   String cod_id = (String) request.getParameter("input");
		   HttpSession session = request.getSession();
		   Connection conn = logUser.getStoredConnection(session);
		   String errorString = null;
		   List<database> list = null;
		   List<Hdiscounts> stat = null;
		   if (cod_id.length()!= 0 ) {
			   if (Pattern.matches("[0-9]+", cod_id)) {
				   Integer cod_id1 = Integer.parseInt(cod_id);
			   try {
				list=Discount.infostatistics(conn, cod_id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			   if (list != null) {
				
				   try {
					stat=Discount.idhistory(conn, cod_id1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
				request.setAttribute("idstat", stat);
				   
		        request.setAttribute("cod_id", list.get(0).cod_id());
		        request.setAttribute("foto", list.get(0).getfoto());
		        request.setAttribute("fio", list.get(0).getsurname() + " " + list.get(0).getfirst_name() + " " + list.get(0).getotchestvo());
		        request.setAttribute("otdel", list.get(0).getotdel());
		        request.setAttribute("position", list.get(0).getposition());
		        request.setAttribute("discount", list.get(0).getdiscount());
		        }
			   else {System.out.println("errorString - " + errorString); request.setAttribute("error", "ID consists of 8 digits !!!");}
			}
			   else {System.out.println("errorString - " + errorString); request.setAttribute("error", "ID contains only numbers !!!");}
			}
			   else {System.out.println("errorString - " + errorString); request.setAttribute("error", "Enter ID data !!!");} 
			   
	       doGet(request, response);
	   }
	}


