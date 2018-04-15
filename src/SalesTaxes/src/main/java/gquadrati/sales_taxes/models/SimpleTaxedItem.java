package gquadrati.sales_taxes.models;

import gquadrati.sales_taxes.domain.ItemTaxCalculator;
import gquadrati.sales_taxes.helpers.DoubleHelper;

//Item Decorator - Decorates item with tax price
/**
 * @author Greta Quadrati
 *
 *         Simple Implementation of TaxedItem interface It uses an
 *         ItemTaxCalculator object to calculate to decorate the Item with taxes
 */
public class SimpleTaxedItem implements TaxedItem {

	private ItemTaxCalculator itemTaxCalculator;

	private Item baseItem;
	private double taxes;
	private double total;

	/**
	 * Base constructor
	 * 
	 * @param baseItem
	 *            the item to decorate with taxes
	 * @param itemTaxCalculator
	 *            the tax calculator
	 */
	public SimpleTaxedItem(Item baseItem, ItemTaxCalculator itemTaxCalculator) {
		this.itemTaxCalculator = itemTaxCalculator;
		this.baseItem = baseItem;

		calculateTaxes();
	}

	@Override
	public int getId() {
		return baseItem.getId();
	}

	@Override
	public String getName() {
		return baseItem.getName();
	}

	@Override
	public String GetCategory() {
		return baseItem.GetCategory();
	}

	@Override
	public boolean getIsImported() {
		return baseItem.getIsImported();
	}

	@Override
	public double getPrice() {
		
		return baseItem.getPrice() + taxes;
	}

	@Override
	public double getTaxPrice() {
		return taxes;
	}



	@Override
	public Item getDecoratedItem() {
		return baseItem;
	}

	

	// Private Methods

	private void calculateTaxes() {

		this.taxes = itemTaxCalculator.calculateTaxesFor(baseItem);
		this.total = DoubleHelper.RoundingUp(this.baseItem.getPrice() + this.taxes, 2);
	}

}
