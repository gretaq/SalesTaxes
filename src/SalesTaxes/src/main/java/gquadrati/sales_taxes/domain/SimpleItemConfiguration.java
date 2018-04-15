package gquadrati.sales_taxes.domain;

import java.util.HashSet;

import gquadrati.sales_taxes.models.Item;

/**
 * @author Greta Quadrati
 *
 *         A simple implementation of ItemConfiguration interface. A more
 *         complex one could be made with a DB connection
 */
public class SimpleItemConfiguration implements ItemConfiguration {

	/**
	 * Items' categories
	 * 
	 * They should be saved into a DB table, in a more complex scenario
	 */
	public static final String CAT_BOOK = "books";
	public static final String CAT_FOOD = "food";
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

	@Override
	public double getSalesTaxPercentage() {
		return 0.10;
	}

	@Override
	public double getImportTaxPercentage() {
		return 0.05;
	}

}
