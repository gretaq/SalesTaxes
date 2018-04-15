package gquadrati.sales_taxes.models;

import java.util.stream.Stream;

/**
 * @author Greta Quadrati
 *
 *         Interface for the Receipt item
 *         Is not possible to directly add items to it
 */
public interface Receipt {

	/**
	 * @return the total of all items within the Receipt and their taxes
	 */
	double getTotal();

	/**
	 * @return the Taxes Total of all items within the Receipt
	 */
	double getTaxesTotal();

	/**
	 * @return the stream of the Items within the Receipt
	 */
	Stream<Item> getItems();
}
