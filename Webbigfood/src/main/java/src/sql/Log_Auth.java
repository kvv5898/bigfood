package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.bigfood.tabl.Auth;
import src.other.date_time;

public class Log_Auth {
	
	public static void Log(Connection conn, //
		String ip, String user_name, String password, String session, String login_in) throws SQLException {
        String sql = "Insert into auth(date, ip, user_in, pass_in, session, login_in) values (?,?,?,?,?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
 
        
        add.setString(1, date_time.date());
        add.setString(2, ip);
        add.setString(3, user_name);
        add.setString(4, password);
        add.setString(5, session);
        add.setString(6, login_in);
 
        add.executeUpdate();
	
	
}
	
	public static List<Auth> Find_All (Connection conn) throws SQLException {
	        String sql = "Select * from auth";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();
	        List<Auth> list = new ArrayList<Auth>();
	        while (rs.next()) {
	        	
	        	Integer id = rs.getInt("id");
	        	String date = rs.getString("date");
	            String ip = rs.getString("ip");
	            String user_in = rs.getString("user_in");
	            String pass_in = rs.getString("pass_in");
	            String session = rs.getString("session");
	            String login_in = rs.getString("login_in");

	            Auth us = new Auth(id, date, ip, user_in, pass_in, session, login_in);
	            
	            us.setid(id);
	            us.setdate(date);
	            us.setip(ip);
	            us.setuser_in(user_in);
	            us.setpass_in(pass_in);
	            us.setsession(session);
	            us.setlogin_in(login_in);
	            list.add(us);
	        }
	        return list;
		
		
	}
	}