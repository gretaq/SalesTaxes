package gquadrati.sales_taxes.models;

/**
 * @author Greta Quadrati
 * 
 *         Tax Decorator interface for objects implementing the Item interface.
 *         It extends the Item interface adding two extra function for tax 
 * 
 */
public interface TaxedItem extends Item {

	/**
	 * @return tax price only (2 decimals)
	 */
	double getTaxPrice();

	/**
	 * @return the price and tax sum
	 */
	double getTotal();
}
