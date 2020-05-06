package src.bigfood.tabl;




public class Hdiscounts {

	   private Integer id;
	   private Integer cod_id;
	   private String date;
	   private float discount;
       private float total;
	    
	   public void history(Integer id, Integer cod_id, String date, float discount, float total) {
		   this.id = id;
		   this.cod_id = cod_id;
		   this.date = date;
		   this.discount = discount;
           this.total = total;
	       
	      
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
	   
	   public String getdate() {
	       return date;
	   }
	 
	   public void setdate(String date) {
	       this.date = date;
	   }
	 
	   
	   public float getdiscount() {
	       return discount;
	   }
	 
	   public void setdiscount(float discount) {
	       this.discount = discount;
	   }

           public float gettotal() {
	       return total;
	   }
	 
	   public void settotal(float total) {
	       this.total = total;
	   }


}