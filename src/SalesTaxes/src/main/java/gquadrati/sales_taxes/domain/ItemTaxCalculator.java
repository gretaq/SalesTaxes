package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.models.Item;

public interface ItemTaxCalculator {
	
	public double calculateTaxesFor(Item item);
}
