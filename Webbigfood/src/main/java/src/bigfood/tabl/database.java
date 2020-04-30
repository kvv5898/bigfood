package src.bigfood.tabl;




public class database {

	   private Integer id;
	   private Integer cod_id;
	   private String foto;
	   private String surname;
	   private String first_name;
	   private String otchestvo;
	   private String otdel;
	   private String position;
	   private float discount;
	    
	   public database(Integer id, Integer cod_id, String foto, String surname, String first_name, String otchestvo, String otdel, String position, float discount) {
		   this.id = id;
		   this.cod_id = cod_id;
		   this.foto = foto;
		   this.surname = surname;
		   this.first_name = first_name;
		   this.otchestvo = otchestvo;
		   this.otdel = otdel;
		   this.position = position;
		   this.discount = discount;
	       
	      
	   }
	    
	   	   
	public Integer id() {
	       return id;
	   }
	 
	   public void setid(Integer id) {
	       this.id = id;
	   }
	 
	   public Integer cod_id() {
	       return cod_id;
	   }
	 
	   public void setcod_id(Integer cod_id) {
	       this.cod_id = cod_id;
	   }
	   
	   public String getfoto() {
	       return foto;
	   }
	 
	   public void setfoto(String foto) {
	       this.foto = foto;
	   }
	 
	   
	   public String getsurname() {
	       return surname;
	   }
	 
	   public void setsurname(String surname) {
	       this.surname = surname;
	   }
	   
	   
	   public String getfirst_name() {
	       return first_name;
	   }
	 
	   public void setfirst_name(String first_name) {
	       this.first_name = first_name;
	   }
	   
	   public String getotchestvo() {
	       return otchestvo;
	   }
	 
	   public void setotchestvo(String otchestvo) {
	       this.otchestvo = otchestvo;
	   }
	   
	   public String getotdel() {
	       return otdel;
	   }
	 
	   public void setotdel(String otdel) {
	       this.otdel = otdel;
	   }

	   
	   public String getposition() {
	       return position;
	   }
	 
	   public void setposition(String position) {
	       this.position = position;
	   }
	   
	   public float getdiscount() {
	       return discount;
	   }
	 
	   public void setdiscount(float discount) {
	       this.discount = discount;
	   }
}