package gquadrati.sales_taxes.models;

import java.util.stream.Stream;

public interface ShoppingBasket {

	
	public void addItem(Item item);
	
	public Stream<Item> getItems();
	
	
	
}
