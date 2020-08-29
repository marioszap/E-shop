//This class is a subclass of the class Exception which will output an exception
//when an order made by a buyer isn't in order list
public class NotInOrderListException extends Exception{

	//this is how we define the message of the output when an exception occurs
	public NotInOrderListException(){
		super("This order does not exist in our orderlist");
	}
}
