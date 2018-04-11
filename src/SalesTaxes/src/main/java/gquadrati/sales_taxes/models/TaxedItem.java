package gquadrati.sales_taxes.models;

public interface TaxedItem extends Item {

	
	double getTaxPrice();
	
	double getTotal();
}
