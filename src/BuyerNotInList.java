//This class is a subclass of the class Exception which will output an exception
//when the buyer entered by a user isn't in the buyers list
public class BuyerNotInList extends Exception{
	
	//this is how we define the message of the output when an exception occurs
	public BuyerNotInList() {
		super("The buyer you want to remove doesn 't exist in oyr Buyerlist");
	}

}
