package src.bigfood.servlet.jsp;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.bigfood.conn.JDBCPostgreSQL;
import src.bigfoodlog.logUser;


 
@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Request in LoginView.jsp");
    	
    	Connection conn = null;
		try {
			conn = JDBCPostgreSQL.conni();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	logUser.storeConnection(request, conn);
    	
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/LoginView.jsp");
 
        dispatcher.forward(request, response);
    }
        
}