//This class is a subclass of the class Exception which will output an exception
//when the amount of products' ordered is greater than the available products
public class orderBiggerThanStockException extends Exception{
	
	//this is how we define the message of the output when an exception occurs
	public orderBiggerThanStockException() {
		super("Too many items ordered. Please wait until we renew our stock, or buy"
				+ "a smaller quantity for now.");
	}
}
