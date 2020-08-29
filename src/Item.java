//A class that can't have instances 
//This specific class defines the characteristics that each item should have 
public abstract class Item {
	String prName = "";
	double price;  
	String description = "";
	int stock, ID;
	String details = "";
	
	//With this method we choose an item and learn basic information about it 
	public String getBasicInfo(Item e) {
		 String basicInfo = "This product 's name is: "+e.prName+". It costs: "+e.price+
				 " Euros. Some info about this product: "+e.description+". "+e.stock+
				 " products of this type still in store. Product 's ID: "+e.ID+".";

		return basicInfo;
		}
	//With this method we learn more specific information in comparison to the previous method
	public String getDetails(Item e) {
		return e.details;
	}
	//This method prints out both the outputs of the previous two
	public String toString(Item e) {
		String allInfo = getBasicInfo(e) + getDetails(e);  
		return allInfo;	
	}
}
