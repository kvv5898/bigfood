package src.bigfood.conn;
 
//STEP 1. Import required packages
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class JDBCPostgreSQL {
 
   //  Database credentials
      static final String DB_URL = "jdbc:postgresql://ec2-176-34-97-213.eu-west-1.compute.amazonaws.com/d4ssf6aq8r0svn";
      static final String USER = "ekjqojibcuyxgz";
      static final String PASS = "b6e9a70ce6a6b5a4b7919a1c577fed7bd7e8ca08df51df5f804721437957a897";
 
      public static Connection conni () throws SQLException,
      ClassNotFoundException {
 
	System.out.println("Testing connection to PostgreSQL JDBC");
 
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		
	}
 
	System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection(DB_URL, USER, PASS);
 
	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		
	}
 
	if (connection != null) {
		System.out.println("You successfully connected to database now");
	} else {
		System.out.println("Failed to make connection to database");
	}
	return connection;
      }
     }