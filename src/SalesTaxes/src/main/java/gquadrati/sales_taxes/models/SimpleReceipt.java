package gquadrati.sales_taxes.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import gquadrati.sales_taxes.domain.ItemTaxCalculator;
import gquadrati.sales_taxes.helpers.DoubleHelper;

/**
 * @author Greta Quadrati
 * 
 *         Simple implementation of Receipt interface
 * 
 *         It's created from a ShoppingBasket item 
 *         It calculates shopping items' taxes by the ItemTaxCalculator object.
 *         
 */
public class SimpleReceipt implements Receipt {

	List<TaxedItem> taxedItems;

	double total;
	double salesTaxesTotal;

	/**
	 * SImpleReceipt can ben construct with a ShoppingBasket and an ItemTaxCalculator objects
	 * @param shoppingBasket the shopping basket of which to create the receipt
	 * @param itemTaxCalculator the object that calculates the taxes of each item within th shopping basket
	 */
	public SimpleReceipt(ShoppingBasket shoppingBasket, ItemTaxCalculator itemTaxCalculator) {
		
		taxedItems = shoppingBasket.getItems().map(i -> new SimpleTaxedItem(i, itemTaxCalculator))
				.collect(Collectors.toList());

		total = taxedItems.stream().mapToDouble(t -> t.getTotal() * t.getQuantity()).sum();
		total = DoubleHelper.RoundingUp(total, 2);

		salesTaxesTotal = taxedItems.stream().mapToDouble(t -> t.getTaxPrice() * t.getQuantity()).sum();
		salesTaxesTotal = DoubleHelper.RoundingUp(salesTaxesTotal, 2);

	}

	@Override
	public double getTotal() {
		return total;
	}

	@Override
	public double getTaxesTotal() {
		return salesTaxesTotal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Stream<Item> getItems() {
		List<? extends Item> items = taxedItems;
		return (Stream<Item>) items.stream();
	}

	@Override
	public String toString() {
		String val = "Total " + total + "\nSales Total " + salesTaxesTotal;

		for (TaxedItem taxedItem : taxedItems) {
			val += "\n " + taxedItem.GetCategory() + " " + taxedItem.getTotal();
		}

		return val;
	}
}
