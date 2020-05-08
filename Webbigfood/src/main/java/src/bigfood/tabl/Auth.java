package src.bigfood.tabl;




public class Auth {

	   private Integer id;
	   private String date;
	   private String ip;
	   private String host;
	   private String getway;
	   private String user_in;
	   private String pass_in;
	   private String session;
	   private String login_in;
	    
	   public Auth (Integer id, String date, String ip, String host, String getway, String user_in, String pass_in, String session, String login_in) {
		   this.id = id;
		   this.date = date;
		   this.ip = ip;
		   this.ip = host;
		   this.ip = getway;
		   this.user_in = user_in;
		   this.pass_in = pass_in;
		   this.session = session;
		   this.login_in = login_in;
	       
	      
	   }
	    
	   	   
	public Integer id() {
	       return id;
	   }
	 
	   public void setid(Integer id) {
	       this.id = id;
	   }
	 
	   public String date() {
	       return date;
	   }
	 
	   public void setdate(String date) {
	       this.date = date;
	   }
	   
	   public String getip() {
	       return ip;
	   }
	 
	   public void setip(String ip) {
	       this.ip = ip;
	   }
	 
	   public String gethost() {
	       return host;
	   }
	 
	   public void sethost(String host) {
	       this.host = host;
	   }
	   
	   public String getgetway() {
	       return getway;
	   }
	 
	   public void setgetway(String getway) {
	       this.getway = getway;
	   }
	   
	   public String getuser_in() {
	       return user_in;
	   }
	 
	   public void setuser_in(String user_in) {
	       this.user_in = user_in;
	   }
	   
	   
	   public String getpass_in() {
	       return pass_in;
	   }
	 
	   public void setpass_in(String pass_in) {
	       this.pass_in = pass_in;
	   }
	   
	   public String getsession() {
	       return session;
	   }
	 
	   public void setsession(String session) {
	       this.session = session;
	   }
	   
	   public String getlogin_in() {
	       return login_in;
	   }
	 
	   public void setlogin_in(String login_in) {
	       this.login_in = login_in;
	   }
}