package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.models.Item;


/**
 * @author Greta Quadrati
 *
 * Interface for Item Tax Calculator
 */
public interface ItemTaxCalculator {
	
	/**
	 * @param item
	 * @return
	 */
	public double calculateTaxesFor(Item item);
}
