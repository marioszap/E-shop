//This class is a subclass of the class Exception which will output an exception
//when a user enters a wrong username  or password 
public class incorrectInputException extends Exception{
	
	//this is how we define the message of the output when an exception occurs
	public incorrectInputException() {
		super("The username or password you entered is incorrect");
	}
}
