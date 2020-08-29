//It's a subclass of the Class Item which defines the extra characteristics of a
//notebook in relation to an item
public class Notebook extends Item{
	
	int numOfSubs;
	String dets ="";
	
	//This constructor will be used to create instances of this class demanding 
	//the most important characteristics of a notebook to be inserted when making the
	//object
	public Notebook(int x, String name, int id, int st, double pr) {
		x = numOfSubs;
		prName = name;
		ID = id;
		stock = st;
		price = pr;
	}
}
