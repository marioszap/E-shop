//This class is a subclass of the class Exception which will output an exception
//when the product entered by a user is already in the items list
public class AlreadyInListException extends Exception{
	
	//this is how we define the message of the output when an exception occurs
	public AlreadyInListException() {
		super("The product you entered is already in the list");
	}
}
