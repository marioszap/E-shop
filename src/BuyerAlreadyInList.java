//This class is a subclass of the class Exception which will output an exception
//when the buyer entered by a user is already in the buyers list
public class BuyerAlreadyInList extends Exception{
	
	//this is how we define the message of the output when an exception occurs
	public BuyerAlreadyInList() {
		super("The new buyer you want to add is already in our Buyerlist");
	}
}
