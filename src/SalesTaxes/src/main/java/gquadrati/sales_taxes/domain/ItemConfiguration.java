package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.models.Item;


/**
 * @author Greta Quadrati
 *
 * Interface representing the configuration for the object Item
 */
public interface ItemConfiguration {
	
	/**
	 * @param item
	 * @return whether if the item is tax-free or not
	 */
	boolean isTaxFree(Item item);
	
	/**
	 * @return the up-to-date Sales Tax percentage (2 decimals)
	 */
	double getSalesTaxPercentage();
	
	/**
	 * @return the up-to-date Import Tax percentage (2 decimals)
	 */
	double getImportTaxPercentage();
}
