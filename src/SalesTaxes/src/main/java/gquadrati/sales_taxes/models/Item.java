package gquadrati.sales_taxes.models;

/**
 * @author Greta Quadrati
 * 
 *         Interface for the object Item
 *
 */
public interface Item {

	int getId();

	String getName();

	String GetCategory();

	boolean getIsImported();

	double getPrice();

	int getQuantity();

	/**
	 * @param quantity increment item quantity with this value
	 */
	void addQuantity(int quantity);
	
	
	/**
	 * @param quantity the item quantity to decrement
	 * @return the remaining quantity
	 */
	int removeQuantity(int quantity);

}
