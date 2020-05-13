package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.bigfood.tabl.Hdiscounts;
import src.bigfood.tabl.database;
import src.other.date_time;

public class Discount {
	
	
        public static Float Search (Integer cod_id, Connection conn) throws SQLException {
        
		System.out.println("Search Discount for cod_id:" +  cod_id);
		
		String sql = "Select discount FROM database WHERE cod_id=?";
 
        PreparedStatement find = conn.prepareStatement(sql);
        find.setInt(1, cod_id);
        ResultSet rs = find.executeQuery();
        Float discount = null;
        if (rs.next()) {
        	discount = rs.getFloat("discount");
        }
		return discount;
		
}
	
	public static void ADD (float discount, Integer cod_id, Connection conn) throws SQLException {
        
		System.out.println("Discount Update: " + "  /  " + discount + "  /  " + cod_id + "  /  " + conn);
		
		String sql = "Update database set discount = ? WHERE cod_id=?";
 
        PreparedStatement add = conn.prepareStatement(sql);
        add.setFloat(1, discount);
        add.setInt(2, cod_id);
        add.executeUpdate();	
}
	
	public static List<database> infodiscount(Connection conn) throws SQLException {
        String sql = "Select * from database";
        System.out.println("Search info discounts in DB");
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<database> list = new ArrayList<database>();
        while (rs.next()) {
        	
        	Integer id = rs.getInt("id");
        	Integer cod_id = rs.getInt("cod_id");
        	String foto = rs.getString("foto");
            String surname = rs.getString("surname");
            String first_name = rs.getString("first_name");
            String otchestvo = rs.getString("otchestvo");
            String otdel = rs.getString("otdel");
            String position = rs.getString("position");
            Float discount = rs.getFloat("discount");
            
            database us = new database(id, cod_id, foto, surname, first_name, otchestvo,otdel, position, discount);
            
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
	
	
	public static List<database> infostatistics(Connection conn, Integer cod_id) throws SQLException {
        System.out.println("Search info statistics in DB - " + cod_id);
		String sql = "Select * from database WHERE cod_id=?";
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
            Float discount = rs.getFloat("discount");
            
            database us = new database(id, cod_id, foto, surname, first_name, otchestvo,otdel, position, discount);
            
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
            return list;
        }
        return null;
}
	
	
	
	
		
		public static void Dhistory(Connection conn, //
	        Integer cod_id, Float discount, Float total) throws SQLException {
	        String sql = "Insert into dhistory (cod_id, date, discount, total) values (?,?,?,?)";
	        
	        PreparedStatement add = conn.prepareStatement(sql);
	 
	        add.setInt(1, cod_id);
	        add.setString(2, date_time.date());
	        add.setFloat(3, discount);
	        add.setFloat(4, total);
	 
	        add.executeUpdate();
	}
		
		
		public static List<Hdiscounts> infohistory(Connection conn) throws SQLException {
	        String sql = "Select * from dhistory ORDER BY date";
	        System.out.println("Search info history discounts in DB");
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();
	        List<Hdiscounts> list = new ArrayList<Hdiscounts>();
	        while (rs.next()) {
	        	
	        	Integer id = rs.getInt("id");
	        	Integer cod_id = rs.getInt("cod_id");
	        	String date = rs.getString("date");
	            Float discount = rs.getFloat("discount");
	            Float total = rs.getFloat("total");
	            
	            Hdiscounts us = new Hdiscounts();
	            
	            us.setid(id);
	            us.setcod_id(cod_id);
	            us.setdate(date);
	            us.setdiscount(discount);
	            us.settotal(total);;
	            list.add(us);
	        }
	        return list;
	}	
	
		public static List<Hdiscounts> idhistory(Connection conn, Integer cod_id) throws SQLException {
	        String sql = "SELECT date, discount, total FROM dhistory WHERE cod_id=? ORDER BY date";
	        System.out.println("Search id history discounts in DB");
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, cod_id);
	        ResultSet rs = pstm.executeQuery();
	        List<Hdiscounts> list = new ArrayList<Hdiscounts>();
	        while (rs.next()) {
	        	
	        	String date = rs.getString("date");
	            Float discount = rs.getFloat("discount");
	            Float total = rs.getFloat("total");
	            
	            Hdiscounts us = new Hdiscounts();
	            
	            us.setdate(date);
	            us.setdiscount(discount);
	            us.settotal(total);;
	            list.add(us);
	        }
	        return list;
	}	

		public static List<Hdiscounts> Searchlastrecord (Connection conn) throws SQLException {
	        
			System.out.println("Search last record");
			
			String sql = "SELECT * FROM dhistory ORDER BY id DESC LIMIT 1";
	 
			PreparedStatement pstm = conn.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();
	        List<Hdiscounts> list = new ArrayList<Hdiscounts>();
	        while (rs.next()) {
	        	
	        	Integer id = rs.getInt("id");
	        	Integer cod_id = rs.getInt("cod_id");
	        	String date = rs.getString("date");
	            Float discount = rs.getFloat("discount");
	            Float total = rs.getFloat("total");
	            
	            Hdiscounts us = new Hdiscounts();
	            
	            us.setid(id);
	            us.setcod_id(cod_id);
	            us.setdate(date);
	            us.setdiscount(discount);
	            us.settotal(total);;
	            list.add(us);
	        }
	        return list;
	}	
		
		public static void dellastrecordhistory (Integer id, Connection conn) throws SQLException {
	        
			System.out.println("last record delete id:" + id);
			
			String sql = "DELETE From dhistory WHERE Id=?";
	 
	        PreparedStatement add = conn.prepareStatement(sql);
	        add.setFloat(1, id);
	        add.executeUpdate();	
	}	
		
}
