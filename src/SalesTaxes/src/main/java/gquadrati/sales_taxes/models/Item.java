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

}
