package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.helpers.DoubleHelper;
import gquadrati.sales_taxes.models.Item;

public class SimpleItemTaxCalculator implements ItemTaxCalculator {

	ItemConfiguration itemConfiguration;
	private double basicSalesTax;
	private double importedItemTax;

	
	public SimpleItemTaxCalculator(ItemConfiguration itemConfiguration) {
		this.itemConfiguration = itemConfiguration;
		
		//n/100
		this.basicSalesTax = 0.1; 
		this.importedItemTax = 0.05;
	}

	@Override
	public double calculateTaxesFor(Item item) {

		double taxes = 0f;

		//Round the value to the nearest 0.05 decimal both taxes
		if (!itemConfiguration.isTaxFree(item))
			taxes +=  DoubleHelper.RoundToTheNearestValue(item.getPrice() * basicSalesTax, 0.05);

		if(item.getIsImported())
			taxes +=  DoubleHelper.RoundToTheNearestValue(item.getPrice() * importedItemTax, 0.05);
		
		taxes = DoubleHelper.RoundingUp(taxes, 2);

		return taxes;
	}
}
