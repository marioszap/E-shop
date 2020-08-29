import java.util.ArrayList;
import java.util.Scanner;

//This class is a subclass of ItemList and it represents the eshop's options for a user
public class EShop extends ItemList{
	
	//Owner owner = new Owner(); 
	
	ArrayList<Pen> PensList = new ArrayList<Pen>(); //this list contains only products of type Pen
	ArrayList<Pencil> PencilsList = new ArrayList<Pencil>(); //this list contains only products of type Pencil
	ArrayList<Paper> PaperList = new ArrayList<Paper>(); //this list contains only products of type Paper
	ArrayList<Notebook> NotebooksList = new ArrayList<Notebook>(); //this list contains only products of type
	//Notebook 
	//and whenever an item is added in our items list depending on what type of item it is, it is added to the
	//appropriate list above and the same goes for deleting an item from our items list
	
	
	int x,y,w,id;
	double tp;
	char type;
	String name = "", clr = "", nm = "", mail = "", passw = "";
	boolean ok;
	
	Scanner scan = new Scanner(System.in);
	//A method that adds an item to the ItemsList and then it casts the item to its appropriate subclass in order
	//to add it to the correct list 
	void addItem(Item e) {
		ItemsList.add(e);
		if(e instanceof Pen) 
			PensList.add((Pen)e);
		
		else if(e instanceof Pencil) 
			PencilsList.add((Pencil)e);
		
		else if (e instanceof Paper)
			PaperList.add((Paper)e);
		
		else if(e instanceof Notebook)
			NotebooksList.add((Notebook)e);
	}
	
	//This method asks the user to type in the ID of the product he is looking for and it finds it for him and
	//prints out its basic information
	void getItemById() {
		System.out.println("Which is the Id that you want to search?");
		id = scan.nextInt();
		
		for(Item e: ItemsList) {
			if(e.ID == id) 
				System.out.println(e.getBasicInfo(e));
		}
	}
	
	
	//This method removes an item from ItemsList and then checks what type of item it is and removes it
	//from its type's list and checks if it is in the item list in order to throw 
	//exception in that case
	void removeItem(Item e) {
		ItemsList.remove(e);
		if(!ItemsList.contains(e)) {
			try {
			throw new ItemNotInItemsListException();
			}catch(ItemNotInItemsListException ex) {
				System.out.println(ex.getMessage());}
		}
		if(e instanceof Pen) PensList.remove(e);
		else if(e instanceof Pencil) PencilsList.remove(e);
		else if(e instanceof Paper) PaperList.remove(e);
		else if(e instanceof Notebook) NotebooksList.remove(e);
	}
	
	
	//This method asks the user to enter email and password of the Buyer they want to enter in the
	//BuyersList and then checks if that Buyer is already in it, in order to throw an exception
	void addBuyer() {
		System.out.println("Please enter the buyer's email: ");
		mail = scan.nextLine();
		System.out.println("Please enter the buyer's password: ");
		passw = scan.nextLine();
		try {
		for(Buyer e: BuyerList) {
			if(e.email == mail) {
				ok = false;
				throw new BuyerAlreadyInList();
			}
		}
		if(ok) {
		Buyer newBuyer = new Buyer();
		BuyerList.add(newBuyer);
		System.out.println("New buyer added successfully");}
		} catch(BuyerAlreadyInList ex) {System.out.println(ex.getMessage());}
	
	}
	
	
	
	//this method removes a buyer from our buyersList, or throws an error, if they are not in it
	void removeBuyer(Buyer e) {
		try {
		for(Buyer o:BuyerList) {
			if(e.email != o.email) {
				ok = false;
				throw new BuyerNotInList();
				}
			}
		}catch(BuyerNotInList exc) {System.out.println(exc.getMessage());}
		if(ok) {
			for(Buyer o:BuyerList) {
				if(e.email == o.email)
					BuyerList.remove(e);
			}
		}
	} 
	
	
	
//Using this method an Owner can change a product's stock 
void updateItemStock(Item e)	{
			do {
			System.out.println("Please enter the number of new available products"
					+ " of this category");
			y = scan.nextInt();
			if(y<0) System.out.println("This number should be at least 0");
			}while(y>=0);
			e.stock += y;	
	}



//With this method a user can see the available categories of products
void showCategories () {
	int i;
	System.out.println("The available categories of products are:");
	for(i=0; i<45; i++)
	System.out.println("-");
	System.out.println("1. Pens");
	System.out.println("2. Pencils");
	System.out.println("3. Notebooks");
	System.out.println("4. Paper");
}



//With this method we choose a type of item and view all the available products in it
void showProductsInCategory(int x) {
	int i=1;
	
	switch(x) {
		case(1):for(Pen e:PensList) {
			System.out.println(i+". "+e.prName+" ("+e.stock+" available)");
			i++;
		}break;
	
		case(2):for(Pencil e:PencilsList) {
			System.out.println(i+". "+e.prName+" ("+e.stock+" available)");
			i++;
		}break;
		
		case(3):for(Paper e:PaperList) {
			System.out.println(i+". "+e.prName+" ("+e.stock+" available)");
			i++;
		}break;
	
		case(4):for(Notebook e:NotebooksList) {
			System.out.println(i+". "+e.prName+" ("+e.stock+" available)");
			i++;
		}break;
	}
}



//This method prints out all the available information for a product 
void showProduct(Item e) {

			System.out.println(e.getBasicInfo(e)+"\n"+e.getDetails(e));
}


//This method lets an Owner to check a Buyer's status
int checkStatus() {
	int i = 0;
	for(Buyer e:BuyerList) {
		System.out.println(i+". Username: "+e.usrName+"\tCategory: "
		+e.buyerCategory+"\tBonus: "+e.bonus);
		i++;
		}
	return i;
	}
}

