//It's a subclass of the Class Item which defines the extra characteristics of a
//pen in relation to an item
public class Pen extends Item {
	
	String color = "";
	double tipSize;
	
	String dets = "";
	
	//This constructor will be used to create instances of this class demanding 
	//the most important characteristics of a pen to be inserted when making the
	//object
	public Pen(String color, double tipSize,String name, int id, int st, double pr) {
		this.color = color;
		this.tipSize = tipSize;
		prName = name;
		ID = id;
		stock = st;
		price = pr;
	}
}