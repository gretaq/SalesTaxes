package gquadrati.sales_taxes.models;

import java.util.stream.Stream;

public interface Receipt {

	double getTotal();
	
	double getSalesTaxesTotal();
		
	Stream<Item> getItems();
}
