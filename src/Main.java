
public class Main extends Menu{

	public static void main(String[] args) {
	EShop eShop = new EShop();
	
	Pen pen1 = new Pen("blue", 0.7, "crystlgrip", 1234, 2000, 0.98);
	Pen pen2 = new Pen("black", 0.5, "black shark", 1235, 1300, 1.10);
	Pen pen3 = new Pen("blue", 0.5, "supersoft", 1236, 4509, 1.05);
	
	Pencil pencil1 = new Pencil(0.7, 'B', "picasso", 1237, 4352, 0.30);
	Pencil pencil2 = new Pencil(0.5, 'A', "leo", 1238, 6475, 0.23);
	Pencil pencil3 = new Pencil(0.5, 'B', "peli", 1239, 7584, 0.80);
	
	Notebook notebook1 = new Notebook(2, "thinknotes", 1238, 6210, 2.10);
	Notebook notebook2 = new Notebook(3, "create", 1239, 1231, 3.30);
	Notebook notebook3 = new Notebook(4, "your notes", 1240, 8120, 4.09);
	
	Paper paper1 = new Paper(100, "printqual", 1241, 8100, 0.08);
	Paper paper2 = new Paper(500, "drawer", 1242, 1920, 0.09);
	Paper paper3 = new Paper(1000, "saita", 1243, 8321, 0.10);
	
	eShop.addItem(pen1);
	eShop.addItem(pen2);
	eShop.addItem(pen3);
	
	eShop.addItem(pencil1);
	eShop.addItem(pencil2);
	eShop.addItem(pencil3);
	
	eShop.addItem(notebook1);
	eShop.addItem(notebook2);
	eShop.addItem(notebook3);
	
	eShop.addItem(paper1);
	eShop.addItem(paper2);
	eShop.addItem(paper3);
	
	eShop.showProductsInCategory(3);
	
	Buyer kostas = new Buyer();
	kostas.email = "kostas@email";
	kostas.password = "111111";
	kostas.bonus = 0;
	kostas.buyerCategory = "bronze";
	kostas.usrName = "kostasnik";
	
	Buyer nikos = new Buyer();
	nikos.email = "nikos@email";
	nikos.password = "222222";
	nikos.bonus = 10;
	nikos.buyerCategory = "silver";
	nikos.usrName = "nikteo";
	
	Owner owner = new Owner();
	owner.email = "owner@email";
	owner.password = "333333";
	
	kostas.placeOrder(paper3, kostas);
	kostas.placeOrder(pencil2, kostas);
	kostas.buyersCart.showCart();
	
	nikos.placeOrder(paper1, nikos);
	nikos.placeOrder(pencil2, nikos);
	nikos.buyersCart.showCart();
	
	nikos.buyersCart.checkout(nikos);
	
	
	}
}
