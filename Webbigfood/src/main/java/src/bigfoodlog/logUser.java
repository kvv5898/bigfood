package src.bigfoodlog;
 
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import src.bigfood.tabl.User_account;

 
 
public class logUser {
 
    private static int REDIRECT_ID = 0;
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
 
    
    public static void storeConnection(HttpSession session, Connection conn) {
    	System.out.println("Write request:" + session);
    	session.setAttribute(ATT_NAME_CONNECTION, conn);
        System.out.println("Write conn:" + session.getAttribute(ATT_NAME_CONNECTION));
        
    }
 
    
    public static Connection getStoredConnection(HttpSession session) {
    	System.out.println("Read reques - " + session);
        Connection conn = (Connection) session.getAttribute(ATT_NAME_CONNECTION);
        System.out.println("Read conn - " + session.getAttribute(ATT_NAME_CONNECTION));
        return conn;
    }
    
    
    
    public static void storelogUser(HttpSession session, User_account logUser) { 
    	System.out.println("Write logUser for " + logUser.getuser_name() + "(JAVA)");
        session.setAttribute("logUser", logUser);
    }
 
   
    public static User_account getlogUser(HttpSession session) {
        User_account logUser = (User_account) session.getAttribute("logUser");
        if (logUser == null) {
        	System.out.println("No User Info");
        	return null;
        } else {
        	System.out.println("session.getId: - " + session.getId());
        	System.out.println("To read logUser for " + logUser.getuser_name());
        }
        
        return logUser;
    }
 
    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
    	System.out.println("Write id for " + requestUri);
        Integer id = uri_id_map.get(requestUri);
        if (id == null) {
            id = REDIRECT_ID++;
 
            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }
 
        return id;
    }
 
    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = id_uri_map.get(redirectId);
        if (url != null) {
        	System.out.println("getRedirectAfterLoginUrl return: - " + url);
            return url;
        }
        System.out.println("getRedirectAfterLoginUrl return null");
        return null;
    }
 
}