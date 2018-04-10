package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.helpers.FloatTruncator;
import gquadrati.sales_taxes.models.Item;

public class SimpleItemTaxCalculator implements ItemTaxCalculator {

	ItemConfiguration itemConfiguration;
	private double basicSalesTax;
	private double importedItemTaxPercentage;

	public SimpleItemTaxCalculator(ItemConfiguration itemConfiguration) {
		this.itemConfiguration = itemConfiguration;
		this.basicSalesTax = 0.1;
		this.importedItemTaxPercentage = 0.05;
	}

	@Override
	public double calculateTaxesFor(Item item) {

		double taxes = 0f;

		if (!itemConfiguration.isTaxFree(item))
			taxes +=  round(item.getPrice() * basicSalesTax * 100, 5) / 100;

		if(item.getIsImported())
			taxes +=  round(item.getPrice() * importedItemTaxPercentage * 100, 5) / 100;

		//Round the value to the nearest 0.05 decimal
		taxes = FloatTruncator.RoundingUp(taxes, 2);
		//taxes = round(taxes *100, 5) / 100;

		return taxes;
	}


	private double round(double i, int v){
		double val =  Math.round(i/v) * v;
		return val;
	}



}