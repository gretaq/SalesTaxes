package gquadrati.sales_taxes.domain;

import java.util.Hashtable;


import gquadrati.sales_taxes.models.Item;

public class SimpleItemConfiguration implements ItemConfiguration {

	public static final String CAT_BOOK = "books";
	public  static final String CAT_FOOD = "food";
	public static final String CAT_MED = "medical prod.";

	public static final String CAT_COSMETICS = "cosmetics";
	public static final String CAT_ENTERTAINMENT = "entertainment";

	private Hashtable<String, Boolean> taxFreeItems;


	public SimpleItemConfiguration() {

		taxFreeItems = new Hashtable<>();

		taxFreeItems.put(CAT_BOOK, true);
		taxFreeItems.put(CAT_FOOD, true);
		taxFreeItems.put(CAT_MED, true);

		taxFreeItems.put(CAT_COSMETICS, false);
		taxFreeItems.put(CAT_ENTERTAINMENT, false);
	}


	@Override
	public boolean isTaxFree(Item item) {
		return  taxFreeItems.get(item.GetCategory());
	}


}
