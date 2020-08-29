import java.util.Scanner;

public class Menu extends EShop{
	
	Scanner scan = new Scanner(System.in);
	int choice, choice2, choice3, x;
	String mail, pass = "";
	Boolean in1, in2;

	void welcomePage() {
		System.out.println("Please enter your email: ");
		mail = scan.nextLine();
		System.out.println("Now please enter your password: ");
		pass = scan.nextLine();
		for(Buyer e:BuyerList) {
			if(mail == e.email && pass == e.password) {
				in1 = true;
				BuyerEntered(e);
			}
			else in1 = false;
		}
		for(Owner o: OwnersList) {
			if(mail == o.email && pass == o.password) {
				System.out.println("Welcome ");
				in2 = true;
				OwnerEntered(o);
			}else { in2 = false;
			becomeClient(in1, in2);
			}
		}
	}
	
	
	
	void becomeClient(Boolean in1, Boolean in2) {
		if(!in1 && !in2) {
			do {
			System.out.println("Would you like to become our client?"
					+ "(type \"yes\" or \"no\")");
			mail = scan.nextLine();
			}while(mail!="yes" && mail!="no");
			if(mail != "yes") {
				System.out.println("In that case, you can view our stock, but you "
						+ "are unable to make purchases. Is that ok;"
						+ "(type \"yes\" or \"no\")");
				do {
					mail = scan.nextLine();
				if(mail!="yes" && mail!="no")System.out.println("type \"yes\" or \"no\"");
				}while(mail!="yes" && mail!="no");
				if(mail == "no") becomeClient(in1, in2);
				else {System.out.println("So, let's begin");
				Buyer b = new Buyer();
				BuyerEntered(b);
				}
				
			}
		}
	}


	
	void BuyerEntered(Buyer e) {
		System.out.println("Welcome to Anything about school store "+e.usrName+"!!");
		System.out.println("You have collected"+e.bonus+" purchaces points");
		System.out.println("and you have reached "+e.buyerCategory+" buyer level");
		System.out.println("What do you want to do now?");
		System.out.println("You have the following options: ");
		System.out.println("1.Browse store\t2.View cart\t3.Checkout\t4.Back\t5.log out"
				+ "6.Exit");
		System.out.println("(Just type the number of the action you want)");
		do {
		choice = scan.nextInt();
		while(choice!=1 && choice !=2 &&choice!=3&&choice!=4&&choice!=5&&choice!=6) 
			System.out.println("you should choose a number between 1 and 6");
		
		}while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6);
	}

	
void enterChoices(int choice, Buyer e) {
	int qual = 0;
	switch(choice) {
			
	case 1:{
			System.out.println("In order to select the choice you want please type"
					+ "the number you want(5 means back)");
			showCategories();
			do{
			choice2 = scan.nextInt();
			while(choice2!=1&&choice2!=2&&choice2!=3&&choice2!=4&&choice2!=5)
				System.out.println("Yoou can only choose numbers between 1 and 5");
			}while(choice2!=1&&choice2!=2&&choice2!=3&&choice2!=4&&choice2!=5);
			
			switch(choice2) {
				case 1:{
				int i= 0;
				System.out.println("You chose pens");
				showProductsInCategory(choice2);
				for(Pen p:PensList) {
					i++;
				}do {
					System.out.println("type the number of the product you want to choose:");
					choice3 = scan.nextInt();
					if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
					if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				}while(choice3<0&&choice3>=i+1);
				i=0;
				for(Pen p: PensList) {
					i++;
					if(i == choice) {
						showProduct(p);
						do {
						System.out.println("Do you want to buy it?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							enterChoices(choice, e);
						}else {
							e.placeOrder(p,e);
							System.out.println("Your purchase took place successfully");
							BuyerEntered(e);
						}
					}else if(i+1==choice) enterChoices(choice, e);
				}
				break;
				}
			
				case 2:{
				int i=0;
				System.out.println("You chose pencils");
				showProductsInCategory(choice2);
				for(Pencil p:PencilsList) {
					i++;
				}do {
					System.out.println("type the number of the product you want to choose:");
					choice3 = scan.nextInt();
					if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" means back)");
					if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" means back)");
				}while(choice3<0&&choice3>=i+1);
				i=0;
				for(Pencil p: PencilsList) {
					i++;
					if(i == choice) {
						showProduct(p);
						do {
						System.out.println("Do you want to buy it?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							enterChoices(choice, e);
						}else {
							e.placeOrder(p,e);
							System.out.println("Your purchase took place successfully");
							BuyerEntered(e);
						}
					}else if(i+1==choice) enterChoices(choice, e);
				}
				break;
				}
			
				case 3:{
				int i = 0;
				System.out.println("You chose Notebooks");
				showProductsInCategory(choice2);
				for(Notebook p:NotebooksList) {
					i++;
				}do {
					System.out.println("type the number of the product you want to choose:");
					choice3 = scan.nextInt();
					if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
					if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				}while(choice3<0&&choice3>=i+1);
				i=0;
				for(Notebook p: NotebooksList) {
					i++;
					if(i == choice) {
						showProduct(p);
						do {
						System.out.println("Do you want to buy it?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							enterChoices(choice, e);
						}else {
							e.placeOrder(p,e);
							System.out.println("Your purchase took place successfully");
							BuyerEntered(e);
						}
					}else if(i+1==choice) enterChoices(choice, e);
				}
				break;
				}
			
				case 4:{
				int i =0;
				System.out.println("You chose paper");
				showProductsInCategory(choice2);
				for(Paper p:PaperList) {
					i++;
				}do {
					System.out.println("type the number of the product you want to choose:");
					choice3 = scan.nextInt();
					if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
					if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				}while(choice3<0&&choice3>=i+1);
				i=0;
				for(Paper p: PaperList) {
					i++;
					if(i == choice) {
						showProduct(p);
						do {
						System.out.println("Do you want to buy it?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							enterChoices(choice, e);
						}else {
							e.placeOrder(p,e);
							System.out.println("Your purchase took place successfully");
							BuyerEntered(e);
						}
					}else if(i+1==choice) enterChoices(choice, e);
				}
				break;
				}
			
				case 5:{
				BuyerEntered(e);
					}
				}
			break;
			}	
	case 2:{
			do {
			e.buyersCart.showCart();
			System.out.println("Type the number of the product you want to choose and if you want to go back"
					+"just type the next number from the last product in your shopping cart, the second next number"
					+ "is to clear your cart, and the third next number to checkout");
			choice2 = scan.nextInt();
			}while(choice2<0&&choice2>e.buyersCart.showCart()+3);
			if(choice2<=e.buyersCart.showCart()) {
				System.out.println("You chose: "+e.buyersCart.orderList.get(choice2).prName);
				System.out.println("What do you want to do with it?(1=remove from cart, 2=change ordered quantity)");
				do {
					choice3 = scan.nextInt();
				}while(choice3!=1&&choice3!=2&&choice3!=3);
			if(choice3 == 3)
				enterChoices(choice, e);
			else if(choice3 == 1)
				e.buyersCart.orderList.remove(choice2);
			else {
				System.out.println("how many of these "+e.buyersCart.orderList.get(choice2).prName+"s do you want?");
				x = scan.nextInt();
				e.buyersCart.changeItemOrderedQuantity(e.buyersCart.orderList.get(choice2), x);
			}
			}else if(choice2 == e.buyersCart.showCart()+1) enterChoices(choice, e);
			else if(choice2 == e.buyersCart.showCart()+2) e.buyersCart.orderList.clear();
			else e.buyersCart.checkout(e);	
			BuyerEntered(e);
			break;
			}
	case 3:{
			e.buyersCart.checkout(e);
			break;
			}
	
	case 4:{
			enterChoices(choice, e);
			break;
			}
	
	
	case 5:{
			welcomePage();
			break;
			}
	
	case 6:{
			System.exit(0);
			}
		}
	}	



void OwnerEntered(Owner o) {
	System.out.println("We Welcome our favourite owner to Anything about school store!\n\n");
	System.out.println("What would you like to do?(Please type in the number that corresponds to the"
	+"action you want to perform)");
	do {
	System.out.println("1=Browse store, 2=Check status, 3=Back, 4=Disconnect, 5=exit system");
	choice = scan.nextInt();
	}while(choice<1&&choice>5);
	
	switch(choice) {
	case 1:{
		System.out.println("In order to select the choice you want please type"
		+ "the number you want(5 means back)");
		showCategories();
		do{
		choice2 = scan.nextInt();
		while(choice2!=1&&choice2!=2&&choice2!=3&&choice2!=4&&choice2!=5)
			System.out.println("Yoou can only choose numbers between 1 and 5");
		}while(choice2!=1&&choice2!=2&&choice2!=3&&choice2!=4&&choice2!=5);
		
		switch(choice2) {
			case 1:{
			int i= 0;
			System.out.println("You chose pens");
			showProductsInCategory(choice2);
			for(Pen p:PensList) {
			i++;
			}do {
				System.out.println("type the number of the product you want to choose:");
				choice3 = scan.nextInt();
				if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
			}while(choice3<0&&choice3>=i+1);
			i=0;
			for(Pen p: PensList) {
				i++;
				if(i == choice) {
					showProduct(p);
					do {
					System.out.println("Do you want to change the chosen product?(Type \"yes\" or \"no\")");
					mail = scan.nextLine();
					}while(mail!="yes"&&mail!="no");
					if(mail=="no") {
						OwnerEntered(o);
					}else {
						updateItemStock(p);
						OwnerEntered(o);
					}
				}else if(i+1==choice) OwnerEntered(o);
			}
			break;
			}
		
			case 2:{
			int i=0;
			System.out.println("You chose pencils");
			showProductsInCategory(choice2);
			for(Pencil p:PencilsList) {
				i++;
			}do {
				System.out.println("type the number of the product you want to choose:");
				choice3 = scan.nextInt();
				if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" means back)");
				if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" means back)");
			}while(choice3<0&&choice3>=i+1);
			i=0;
			for(Pencil p: PencilsList) {
				i++;
				if(i == choice) {
					showProduct(p);
					do {
						System.out.println("Do you want to change the chosen product?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							OwnerEntered(o);
						}else {
							updateItemStock(p);
							OwnerEntered(o);
						}
					}else if(i+1==choice) OwnerEntered(o);
				}
			break;
			}
		
			case 3:{
			int i = 0;
			System.out.println("You chose Notebooks");
			showProductsInCategory(choice2);
			for(Notebook p:NotebooksList) {
				i++;
			}do {
				System.out.println("type the number of the product you want to choose:");
				choice3 = scan.nextInt();
				if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
			}while(choice3<0&&choice3>=i+1);
			i=0;
			for(Notebook p: NotebooksList) {
				i++;
				if(i == choice) {
					showProduct(p);
					do {
						System.out.println("Do you want to change the chosen product?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							OwnerEntered(o);
						}else {
							updateItemStock(p);
							OwnerEntered(o);
						}
					}else if(i+1==choice) OwnerEntered(o);
				}
			}
			break;
			
		
			case 4:{
			int i =0;
			System.out.println("You chose paper");
			showProductsInCategory(choice2);
			for(Paper p:PaperList) {
				i++;
			}do {
				System.out.println("type the number of the product you want to choose:");
				choice3 = scan.nextInt();
				if(choice3<0)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
				if(choice3>i+1)System.out.println("You must type a number from 1 to "+i+1+".("+i+1+" is back)");
			}while(choice3<0&&choice3>=i+1);
			i=0;
			for(Paper p: PaperList) {
				i++;
				if(i == choice) {
					showProduct(p);
					do {
						System.out.println("Do you want to change the chosen product?(Type \"yes\" or \"no\")");
						mail = scan.nextLine();
						}while(mail!="yes"&&mail!="no");
						if(mail=="no") {
							OwnerEntered(o);
						}else {
							updateItemStock(p);
							OwnerEntered(o);
						}
					}else if(i+1==choice) OwnerEntered(o);
				}
			break;
			}
		
			case 5:{
			OwnerEntered(o);
				}
		}}
	
	case 2:{
			System.out.println("You can choose a buyer by typing the number that coresponds"
			+ "to them\n");
			checkStatus();
			do {
			choice2 = scan.nextInt();
			if(choice2<0) System.out.println("you can only type numbers bigger or equal to 0");
			if(choice2>checkStatus()) System.out.println("you can only tyoe numbers smalleror"
			+"equal to the size of our buyerList");
			}while(choice2<0&&choice2>checkStatus());//break
			System.out.println("you chose:"+BuyerList.get(choice2).usrName);
			BuyerList.get(choice2).buyersCart.showCart();
			do {
			System.out.println("Do you want to delete "+BuyerList.get(choice2).usrName+"?(type yes or no)");
			mail = scan.nextLine();
			}while(mail!="yes"&&mail!="no");
			if(mail == "yes") removeBuyer(BuyerList.get(choice2));
			else OwnerEntered(o);
	}
	
	case 3:{
			OwnerEntered(o);
			break;
	}
	
	case 4:{
			welcomePage();
			break;
	}
	
	case 5:{
			System.exit(0);
	}
	}
	
}
}


