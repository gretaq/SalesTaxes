package gquadrati.sales_taxes.domain;

import java.util.HashSet;
import java.util.Hashtable;


import gquadrati.sales_taxes.models.Item;

public class SimpleItemConfiguration implements ItemConfiguration {

	public static final String CAT_BOOK = "books";
	public  static final String CAT_FOOD = "food";
	public static final String CAT_MED = "medical prod.";

	public static final String CAT_COSMETICS = "cosmetics";
	public static final String CAT_ENTERTAINMENT = "entertainment";

	private HashSet<String> taxFreeItemsSet;
	

	public SimpleItemConfiguration() {
		
		taxFreeItemsSet = new HashSet<>();
		taxFreeItemsSet.add(CAT_MED);
		taxFreeItemsSet.add(CAT_FOOD);
		taxFreeItemsSet.add(CAT_BOOK);
	}


	@Override
	public boolean isTaxFree(Item item) {
		
		return taxFreeItemsSet.contains(item.GetCategory());
	}


}
