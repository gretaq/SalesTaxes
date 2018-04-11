package gquadrati.sales_taxes.models;

import gquadrati.sales_taxes.domain.ItemTaxCalculator;
import gquadrati.sales_taxes.helpers.FloatTruncator;

//Item Decorator - Decorates item with tax price
public class SimpleTaxedItem implements TaxedItem {

	private Item baseItem;
	private double taxes;
	private double total;
	
	
	public SimpleTaxedItem(Item baseItem, ItemTaxCalculator itemTaxCalculator)
	{
		this.baseItem = baseItem;
		this.taxes = itemTaxCalculator.calculateTaxesFor(baseItem);
		this.total = FloatTruncator.RoundingUp(this.baseItem.getPrice() + this.taxes, 2);
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
		return baseItem.getPrice();
	}


	@Override
	public double getTaxPrice() {		
		return taxes;
	}


	@Override
	public double getTotal() {
		return total;
	}
	
	
	
	
}
