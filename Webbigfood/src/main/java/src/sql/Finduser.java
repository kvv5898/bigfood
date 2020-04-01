package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.bigfood.tabl.User_account;

public class Finduser {
 
	public static User_account finduser(Connection conn, //
            String user_name, String password) throws SQLException {
		
        String sql = "Select * rule from user_account" //
                + " where user_name = ? and password= ?";
        System.out.println("Find (" + user_name + ") in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user_name);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        
        	Integer user_id = rs.getInt("user_id");
        	String date = rs.getString("date");
        	String surname = rs.getString("surname");
        	String first_Name = rs.getString("first_Name");
        	String otchestvo = rs.getString("otchestvo");
        	String otdel = rs.getString("otdel");
        	String tel = rs.getString("tel");
        	String email = rs.getString("email");
        	String rule  = rs.getString("rule");
        	
            User_account userfind = new User_account(user_id, date, surname, first_Name, otchestvo, otdel, tel, email, user_name, password, rule);
            
			userfind.setuser_id(user_id);
			userfind.setdate(date);
			userfind.setsurname(surname);
			userfind.setfirst_Name(first_Name);
			userfind.setotchestvo(otchestvo);
			userfind.setotdel(otdel);
			userfind.setemail(email);
            userfind.setuser_name(user_name);
            userfind.setpassword(password);
            userfind.setrule(rule);
            
//            Log_finduser.find_log(conn, user_name, password,  result);
            return userfind;
        
    }
	
}
