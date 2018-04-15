package gquadrati.sales_taxes.models;

import java.util.stream.Stream;

/**
 * @author Greta Quadrati
 *
 *         Interface representing the shopping basket.
 *         It's possible to add items to it
 * 
 */
public interface ShoppingBasket {


	/**
	 * @param item the item to add, with quantity 1
	 */
	public void addItem(Item item);
	
	
	/**
	 * @param item the item to add
	 * @param quantity the item's quantity
	 */
	public void addItem(Item item, int quantity);

	
	/**
	 * @param item the item to remove
	 */
	public void removeItem(Item item);
	
	
	/**
	 * @param item
	 * @return the item's quantity in the shopping basket
	 */
	public int getItemQuantity(Item item);
	
	
	/**
	 * @return the stream of all the items in the shopping basket
	 */
	public Stream<Item> getItems();

}
