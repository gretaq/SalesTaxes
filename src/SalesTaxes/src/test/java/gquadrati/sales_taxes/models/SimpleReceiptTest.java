package gquadrati.sales_taxes.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gquadrati.sales_taxes.domain.ItemTaxCalculator;
import gquadrati.sales_taxes.domain.SimpleItemConfiguration;
import gquadrati.sales_taxes.domain.SimpleItemTaxCalculator;

public class SimpleReceiptTest {

	ItemTaxCalculator calculator;

	@Before
	public void setUp() {
		calculator = new SimpleItemTaxCalculator(new SimpleItemConfiguration());
	}

	@Test
	public void TestNotImported() {
		Item item1 = new ShoppingBasketItem(1, "", SimpleItemConfiguration.CAT_BOOK, false, 12.49);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_ENTERTAINMENT, false, 14.99);
		Item item3 = new ShoppingBasketItem(3, "", SimpleItemConfiguration.CAT_FOOD, false, 0.85);
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 1.50);
		assertTrue(receipt.getTotal() == 29.83);
	}

	@Test
	public void TestImported() {
		Item item1 = new ShoppingBasketItem(1, "", SimpleItemConfiguration.CAT_FOOD, true, 10);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_COSMETICS, true, 47.50);
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item2);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 7.65);
		assertTrue(receipt.getTotal() == 65.15);
	}
	
	@Test
	public void TestAll() {
		Item item1 = new ShoppingBasketItem(1, "", SimpleItemConfiguration.CAT_COSMETICS, true, 27.99);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_COSMETICS, false, 18.99);
		Item item3 = new ShoppingBasketItem(3, "", SimpleItemConfiguration.CAT_MED, false, 9.75);
		Item item4 = new ShoppingBasketItem(4, "", SimpleItemConfiguration.CAT_FOOD, true, 11.25);
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 6.70);
		assertTrue(receipt.getTotal() == 74.68);
	}
	
	
	@Test
	public void TestQuantity() {
		Item item1 = new ShoppingBasketItem(1,"", SimpleItemConfiguration.CAT_COSMETICS, true, 27.99, 2);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_FOOD, false, 10.00, 3);
		Item item3 = new ShoppingBasketItem(3, "", SimpleItemConfiguration.CAT_ENTERTAINMENT, false, 10.00, 4);
		Item item4 = new ShoppingBasketItem(4, "", SimpleItemConfiguration.CAT_MED, true, 5.50, 5);
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 13.9);
		assertTrue(receipt.getTotal() == 167.38);
	}
	
	@Test
	public void TestAddQuantity() {
		Item item1 = new ShoppingBasketItem(1,"", SimpleItemConfiguration.CAT_COSMETICS, true, 27.99);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_FOOD, false, 10.00);
		Item item3 = new ShoppingBasketItem(3, "", SimpleItemConfiguration.CAT_ENTERTAINMENT, false, 10.00, 4);
		Item item4 = new ShoppingBasketItem(4, "", SimpleItemConfiguration.CAT_MED, true, 5.50, 5);		
		
		item1.addQuantity(1);
		item2.addQuantity(2);
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 13.9);
		assertTrue(receipt.getTotal() == 167.38);
	}
	
	
	@Test
	public void TestAddSameItemIntoBasket() {
		Item item1 = new ShoppingBasketItem(1,"", SimpleItemConfiguration.CAT_COSMETICS, true, 27.99);
		Item item1bis = new ShoppingBasketItem(1,"", SimpleItemConfiguration.CAT_COSMETICS, true, 27.99);
		Item item2 = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_FOOD, false, 10.00);
		Item item2bis = new ShoppingBasketItem(2, "", SimpleItemConfiguration.CAT_FOOD, false, 10.00);
		Item item3 = new ShoppingBasketItem(3, "", SimpleItemConfiguration.CAT_ENTERTAINMENT, false, 10.00, 4);
		Item item4 = new ShoppingBasketItem(4, "", SimpleItemConfiguration.CAT_MED, true, 5.50, 5);		
		
		ShoppingBasket basket = new SimpleShoppingBasket();
		
		basket.addItem(item1);
		basket.addItem(item1bis);
		basket.addItem(item2);
		basket.addItem(item2bis);
		basket.addItem(item2bis);
		basket.addItem(item3);
		basket.addItem(item4);
		
		Receipt receipt = new SimpleReceipt(basket, calculator);
		
		assertTrue(receipt.getTaxesTotal() == 13.9);
		assertTrue(receipt.getTotal() == 167.38);
	}
	
}
