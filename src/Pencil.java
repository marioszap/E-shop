//It's a subclass of the Class Item which defines the extra characteristics of a
//pencil in relation to an item
public class Pencil extends Item {
	
	double tipSize;
	char type ;
	
	String dets = "";
	
	//This constructor will be used to create instances of this class demanding 
	//the most important characteristics of a pencil to be inserted when making the
	//object
	public Pencil(double tipSize, char type, String name, int id, int st, double pr) {
		this.tipSize = tipSize;
		this.type = type;
		prName = name;
		ID = id;
		stock = st;
		price = pr;
	}
}
