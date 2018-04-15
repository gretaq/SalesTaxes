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
	private HashMap<Item, Integer> itemsInShoppingBasket;

	public SimpleShoppingBasket() {
		itemsInShoppingBasket = new HashMap<Item, Integer>();
	}

	@Override
	public void addItem(Item item) {
		this.addItem(item, 1);
	}

	@Override
	public void addItem(Item item, int quantity) {

		Integer itemInBasketQuantity = itemsInShoppingBasket.getOrDefault(item, 0);

		itemInBasketQuantity += quantity;
		itemsInShoppingBasket.put(item, itemInBasketQuantity);
	}

	@Override
	public void removeItem(Item item) {

		Integer itemInBasketQuantity = itemsInShoppingBasket.get(item);

		if (itemInBasketQuantity != null) {
			itemInBasketQuantity--;

			if (itemInBasketQuantity == 0)
				itemsInShoppingBasket.remove(item);
			else
				itemsInShoppingBasket.put(item, itemInBasketQuantity);
		}
	}

	@Override
	public int getItemQuantity(Item item) {

		return itemsInShoppingBasket.getOrDefault(item, 0);
	}

	@Override
	public Stream<Item> getItems() {

		return itemsInShoppingBasket.keySet().stream();
	}
}
