//It's a subclass of the Class Item which defines the extra characteristics of a
//paper in relation to an item
public class Paper extends Item{
	int weightInGrams;
	int numOfPages;

	String dets ="";
	
	//This constructor will be used to create instances of this class demanding 
	//the most important characteristics of a paper to be inserted when making the
	//object
	public Paper(int x, String name, int id, int st, double pr) {
		x = numOfPages;
		prName = name;
		ID = id;
		stock = st;
		price = pr;
	}
}
