//This class represents items that have been ordered
public class ItemOrdered extends Item{
	int quantity;
	String prName = "";
	
	//This constructor uses an integer that represents quantity and 
	//the item that is being ordered 
	public ItemOrdered(int quantity, Item item) {
		this.quantity = quantity;
		prName = item.prName;
	}
}
