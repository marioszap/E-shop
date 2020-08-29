
import java.util.Scanner;
public class Buyer extends User{
	 
//extra variables that a buyer has in relation to a user	 
	 int bonus;
	 String buyerCategory, usrName;
	 ShoppingCart buyersCart = new ShoppingCart(); //Each buyer has his own cart
	 Scanner scan = new Scanner(System.in);
	 
//this method calculates the bonus award	 
int awardBonus(int payment) {
	
	return payment/10;
}


//This class defines when a buyer will be promoted
void setbuyerCategory(Buyer e){
	if(bonus>=100 && bonus<200) {
		e.buyerCategory = "silver";
		System.out.println("Congratulations!! You have been promoted to silver,"
				+ "now, you have 50% discount on shipping. \nGet to 200 bonus "
				+ "points to get to gold and be able to buy products free of all "
				+ "shipping charges.");
	}
	else if(bonus >= 200) {
		e.buyerCategory = "gold";
		System.out.println("You have proven your loyalty to our shop by collecting"
				+ "200 bonus points. It is our turn to prive our loyalty to you. \n"
				+ "Every single purchase you make from now on, will be sent to your "
				+ "house for free!!! Thank you! ");
		}
	}



//This method places an order by creating an object of type ItemOrdered and asking the user about the desired quantity  
void placeOrder(Item e,Buyer b) {
	String choice ="";
	int quan;
	do {
	System.out.println("Are you sure you Want to order this product?(Type \"yes\" or \"no\")");
	choice = scan.nextLine();
	System.out.println("How many items like this do you want?");
	quan = scan.nextInt();
	}while(choice != "yes" && choice != "no"&&quan<0);
	ItemOrdered order = new ItemOrdered(quan, e);
	b.buyersCart.orderList.add(order);
	}
}




