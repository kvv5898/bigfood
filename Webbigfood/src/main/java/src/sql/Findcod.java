package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.bigfood.tabl.database;

public class Findcod {
 
	public static List<database> findcod(Connection conn, //
			Integer cod_id) throws SQLException {
		
		 String sql = "Select * from database where id = ?";
	        System.out.println("Find (" + cod_id + ") in DB");
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, cod_id);
	        ResultSet rs = pstm.executeQuery();
	        List<database> list = new ArrayList<database>();
	        while (rs.next()) {
	        	
	        	Integer id = rs.getInt("id");
	        	String foto = rs.getString("foto");
	            String surname = rs.getString("surname");
	            String first_name = rs.getString("first_name");
	            String otchestvo = rs.getString("otchestvo");
	            String otdel = rs.getString("otdel");
	            String position = rs.getString("position");
	            String discount1 = rs.getString("discount");
	            float discount= Float.parseFloat(discount1);
	        
	       database us = new database(id, cod_id, foto, surname, first_name, otchestvo, otdel, position, discount); 
	            
	            us.setid(id);
	            us.setcod_id(cod_id);
	            us.setfoto(foto);
	            us.setsurname(surname);
	            us.setfirst_name(first_name);
	            us.setotchestvo(otchestvo);
	            us.setotdel(otdel);
	            us.setposition(position);
	            us.setdiscount(discount);
	            list.add(us);
	}
	        return list;
}
}