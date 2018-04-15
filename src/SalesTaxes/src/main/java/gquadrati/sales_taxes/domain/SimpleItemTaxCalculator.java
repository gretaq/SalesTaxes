package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.helpers.DoubleHelper;
import gquadrati.sales_taxes.models.Item;

/**
 * @author Greta Quadrati
 *
 *         A simple implementation of ItemTaxCalculator interface.
 *         
 *         It uses an ItemConfiguration object for retrieving the up-to-date configuration
 *         to be used throughout the tax calculation process.
 *         
 *         This implementation rounds tax price up to the nearest 0.05 multiple.
 */
public class SimpleItemTaxCalculator implements ItemTaxCalculator {

	ItemConfiguration itemConfiguration;
	private double basicSalesTax;
	private double importedItemTax;

	public SimpleItemTaxCalculator(ItemConfiguration itemConfiguration) {
		this.itemConfiguration = itemConfiguration;

		this.basicSalesTax = itemConfiguration.getSalesTaxPercentage();
		this.importedItemTax = itemConfiguration.getImportTaxPercentage();
	}


	@Override
	public double calculateTaxesFor(Item item) {

		double taxes = 0f;

		// Round the value to the nearest 0.05 decimal both taxes
		if (!itemConfiguration.isTaxFree(item))
			taxes += DoubleHelper.RoundToTheNearestValue(item.getPrice() * basicSalesTax, 0.05);

		if (item.getIsImported())
			taxes += DoubleHelper.RoundToTheNearestValue(item.getPrice() * importedItemTax, 0.05);

		taxes = DoubleHelper.RoundingUp(taxes, 2);

		return taxes;
	}
}
