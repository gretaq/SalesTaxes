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
	 * @param item the item to add
	 */
	public void addItem(Item item);

	
	/**
	 * @param item the item to remove
	 */
	public void removeItem(Item item);
	
	
	/**
	 * @return the stream of all the items in the shopping basket
	 */
	public Stream<Item> getItems();

}
