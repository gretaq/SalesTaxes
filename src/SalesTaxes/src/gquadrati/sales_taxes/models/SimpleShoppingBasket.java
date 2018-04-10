package gquadrati.sales_taxes.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SimpleShoppingBasket implements ShoppingBasket {

	List<Item> itemsInShoppingBasket;
	
	 public SimpleShoppingBasket()
	 {
		 itemsInShoppingBasket = new ArrayList<Item>();
	 }
	 
	
	
	@Override
	public void addItem(Item item) {

		itemsInShoppingBasket.add(item);
	}

	@Override
	public Stream<Item> getItems() {
		
		return itemsInShoppingBasket.stream();
	}

}
