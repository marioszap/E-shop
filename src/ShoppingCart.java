import java.util.ArrayList;
import java.util.Scanner;

//A class that is a subclass of the class ItemList and represents the shopping cart of a buyer 
public class ShoppingCart extends ItemList{
	ArrayList<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
	String nm = "";
	int qua;
	Scanner scan = new Scanner(System.in);
	
	//This method takes as a variable an instance of type ItemOrdered and matches it to an Item in our ItemsList
	//and throws error if the quantity ordered is greater than the available stock
	void addItemOrdered(ItemOrdered o, int i) {
		
		for(Item e : ItemsList) {
			if(o.prName == e.prName) {
				System.out.println("How many "+e.prName+"s would you like?");
				do {
					qua = i;
					if(qua<0)	System.out.println("you can order 0 or more items.");
			}while(qua<0);
				ItemOrdered newOrder = new ItemOrdered(qua, e);
				orderList.add(newOrder);
				try {
				if(e.stock>=qua)
				e.stock -= qua;
				else throw new orderBiggerThanStockException();
				}catch(orderBiggerThanStockException ex) 
				{System.out.println(ex.getMessage());}
			}else System.out.println("The item you chose to order doesn't exist in our ItemsList");
		}	
	}
	
	
	//This method removes an item ordered from our orderlist and renews its stock
	void removeItemOrdered(ItemOrdered o) {
		for(ItemOrdered e:orderList) {
			try {
			if(o.prName == e.prName) {
				orderList.remove(e);
			}else throw new NotInOrderListException();
			}catch(NotInOrderListException ex) {System.out.println(ex.getMessage());}
		}
		o.stock += qua;
	}
	
	
	//This method changes the quantity of an item ordered and if that item ordered isn't in the orderlist it
	//thows an exception
	void changeItemOrderedQuantity(ItemOrdered o, int i) {
		
		for(ItemOrdered e:orderList) {
			try {
			if(e.prName == o.prName && e.quantity == i) {
				System.out.println("Please enter the correct amount of "+e.prName+"s you want");
				e.quantity = i;
			}else throw new NotInOrderListException();
			}catch(NotInOrderListException ex) {System.out.println(ex.getMessage());}
		}
	}
	
	//This method shows each product in a Buyer's cart as well as its quantity and price and prints
	//a suitable message if the buyer's cart is empty
	int showCart() {
		int i = 0;
		for(ItemOrdered e:orderList) {
			i++;
			System.out.println(e.prName+"\t"+e.quantity+"\t"+e.quantity*e.price+"\n");
		}if(i==0) System.out.println("Your cart is empty");
		return i;
	}
	
	
	//This method empties a buyer's cart
	void clearCart() {
		for(ItemOrdered e:orderList) {
			removeItemOrdered(e);		}
	}
	
	//This method makes the purchase calculating the total cost of the content of the cart
	void checkout(Buyer e) {
		double totalPayment;
		showCart();
		System.out.println("Are you ready to pay for the products you ordered?");
		System.out.println("1=Yes, 2=No");
		do {
			qua = scan.nextInt();
			if(qua != 1 || qua !=2 )
				System.out.println("Your answer can only be 1 or 2");
		}while(qua != 1 && qua != 2);
		if(qua == 1) {
			e.awardBonus((int)e.buyersCart.calculateNet(e));
			totalPayment = e.buyersCart.calculateNet(e) + e.buyersCart.calcluateCourierCost(e);
			System.out.println("The total price of all your orders and courier is: "+totalPayment);
		}
	}
	
	//This method calculates the price of the content of the cart
	double calculateNet(Buyer e) {
		double price = 0;
		for(ItemOrdered o:e.buyersCart.orderList) {
			price += o.price;
			System.out.println("The collective price of all your orders is: "+o.price);
		}
		return price;
	}
	
	//This method calculates the cost of Courier 
	int calcluateCourierCost(Buyer e) {
		int i;
		i = (int) (e.buyersCart.calculateNet(e)*0.02);
		if(i<3) i = 3;
		System.out.println("Your courier cost is: "+i);
		if(e.buyerCategory == "gold") i=0;
		if(e.buyerCategory == "silver") i /=2;
		return i;
	}
	
}
