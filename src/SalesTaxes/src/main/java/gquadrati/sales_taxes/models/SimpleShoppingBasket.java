package gquadrati.sales_taxes.models;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author Greta Quadrati
 *
 *         A simple implementation of the shopping basket
 */
public class SimpleShoppingBasket implements ShoppingBasket {

	// For storing/retrieving item from the basket
	private HashMap<Item, Item> itemsInShoppingBasket;

	public SimpleShoppingBasket() {
		itemsInShoppingBasket = new HashMap<Item, Item>();
	}

	@Override
	public void addItem(Item item) {

		Item itemInBasket = itemsInShoppingBasket.get(item);

		if (itemInBasket != null)
			itemInBasket.addQuantity(item.getQuantity());
		else
			itemsInShoppingBasket.put(item, item);
	}

	@Override
	public Stream<Item> getItems() {

		return itemsInShoppingBasket.values().stream();
	}

	@Override
	public void removeItem(Item item) {

		Item itemInBasket = itemsInShoppingBasket.get(item);

		if (itemInBasket != null) {
			int newQuantity = itemInBasket.removeQuantity(item.getQuantity());

			if (newQuantity == 0)
				itemsInShoppingBasket.remove(item);
		}
	}

}
