
public class ItemNotInItemsListException extends Exception{
	public ItemNotInItemsListException() {
		super("The item you want to remove isn't in Items List");
	}
}
