package gquadrati.sales_taxes.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import gquadrati.sales_taxes.domain.ItemTaxCalculator;
import gquadrati.sales_taxes.helpers.FloatTruncator;

public class SimpleReceipt implements Receipt {

	List<TaxedItem> taxedItems;

	double total;
	double salesTaxesTotal;


	public SimpleReceipt(ShoppingBasket shoppingBasket, ItemTaxCalculator itemTaxCalculator)
	{
		taxedItems = shoppingBasket
				.getItems()
				.map(i -> new SimpleTaxedItem(i, itemTaxCalculator))
				.collect(Collectors.toList());
		
		DoubleStream p = taxedItems.stream().mapToDouble(t -> t.getTotal());
		
		total = taxedItems.stream().mapToDouble(t -> t.getTotal()).sum();
		total = FloatTruncator.RoundingDown(total, 2);
		
		salesTaxesTotal = taxedItems.stream().mapToDouble(t -> t.getTaxPrice()).sum();
		salesTaxesTotal = FloatTruncator.RoundingDown(salesTaxesTotal, 2);

	}

	@Override
	public double getTotal() {
		return total;
	}

	@Override
	public double getSalesTaxesTotal() {
		return salesTaxesTotal;
	}

	@Override
	public Stream<Item> getItems() {
		List<? extends Item> items =  taxedItems;
		return (Stream<Item>) items.stream();
	}

	
	@Override
	public String toString()
	{
		String val = "Total " + total
					+ "\nSales Total " + salesTaxesTotal;
		
		for (TaxedItem taxedItem : taxedItems) {
			val += "\n1 " + taxedItem.GetCategory() + " " + taxedItem.getTotal();
		}
		
		return val;
	}
}
