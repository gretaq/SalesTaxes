package gquadrati.sales_taxes.main;

import gquadrati.sales_taxes.domain.*;
import gquadrati.sales_taxes.models.*;

public class Runnable {

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();

	}



	private static void Test1()
	{
		//		Input 1:
		//			1 book at 12.49
		//			1 music CD at 14.99
		//			1 chocolate bar at 0.85


		//		Output 1:
		//			1 book : 12.49
		//			1 music CD: 16.49
		//			1 chocolate bar: 0.85
		//			Sales Taxes: 1.50
		//			Total: 29.83

		ItemConfiguration itemConfiguration = new SimpleItemConfiguration();
		ItemTaxCalculator taxCalculator = new SimpleItemTaxCalculator(itemConfiguration);

		ShoppingBasket shoppingBasket = new SimpleShoppingBasket();

		ShoppingBasketItem item1 = new ShoppingBasketItem("Hitchhiker's Guide to the Galaxy",
				SimpleItemConfiguration.CAT_BOOK, 
				false, 
				12.490);

		ShoppingBasketItem item2 = new ShoppingBasketItem("Queen - The Miracle",
				SimpleItemConfiguration.CAT_ENTERTAINMENT, 
				false, 
				14.990);

		ShoppingBasketItem item3 = new ShoppingBasketItem("Novi Dark",
				SimpleItemConfiguration.CAT_FOOD, 
				false, 
				0.850);

		shoppingBasket.addItem(item1);
		shoppingBasket.addItem(item2);
		shoppingBasket.addItem(item3);

		Receipt  receipt = new SimpleReceipt(shoppingBasket, taxCalculator);

		System.out.println(receipt.toString());
		System.out.println(receipt.getTotal() == 29.830);
	}



	private static void Test3()
	{
		//		Input 3:
		//			1 imported bottle of perfume at 27.99
		//			1 bottle of perfume at 18.99
		//			1 packet of headache pills at 9.75
		//			1 box of imported chocolates at 11.25


		//			Output 3:
		//				1 imported bottle of perfume: 32.19
		//				1 bottle of perfume: 20.89
		//				1 packet of headache pills: 9.75
		//				1 imported box of chocolates: 11.85
		//				Sales Taxes: 6.70
		//				Total: 74.68

		ItemConfiguration itemConfiguration = new SimpleItemConfiguration();
		ItemTaxCalculator taxCalculator = new SimpleItemTaxCalculator(itemConfiguration);

		ShoppingBasket shoppingBasket = new SimpleShoppingBasket();

		ShoppingBasketItem item1 = new ShoppingBasketItem("Chanel n° 4",
				SimpleItemConfiguration.CAT_COSMETICS, 
				true, 
				27.99);
		
		ShoppingBasketItem item2 = new ShoppingBasketItem("Chanel n° 3",
				SimpleItemConfiguration.CAT_COSMETICS, 
				false, 
				18.99);

		ShoppingBasketItem item3 = new ShoppingBasketItem("Headache pills",
				SimpleItemConfiguration.CAT_MED, 
				false, 
				9.75);
		
		ShoppingBasketItem item4 = new ShoppingBasketItem("Box of Swiss Chocolate",
				SimpleItemConfiguration.CAT_FOOD, 
				true, 
				11.25);

		shoppingBasket.addItem(item1);
		shoppingBasket.addItem(item2);
		shoppingBasket.addItem(item3);
		shoppingBasket.addItem(item4);

		Receipt  receipt = new SimpleReceipt(shoppingBasket, taxCalculator);

		System.out.println(receipt.toString());
		System.out.println(receipt.getTotal() == 74.68);
	}


	private static void Test2()
	{
		//		Input 2:
		//			1 imported box of chocolates at 10.00
		//			1 imported bottle of perfume at 47.50

		//		Output 2:
		//			1 imported box of chocolates: 10.50
		//			1 imported bottle of perfume: 54.65
		//			Sales Taxes: 7.65
		//			Total: 65.15


		ItemConfiguration itemConfiguration = new SimpleItemConfiguration();
		ItemTaxCalculator taxCalculator = new SimpleItemTaxCalculator(itemConfiguration);

		ShoppingBasket shoppingBasket = new SimpleShoppingBasket();

		ShoppingBasketItem item1 = new ShoppingBasketItem("Swiss Chocolate",
				SimpleItemConfiguration.CAT_FOOD, 
				true, 
				10.00);

		ShoppingBasketItem item2 = new ShoppingBasketItem("Chanel n° 5",
				SimpleItemConfiguration.CAT_COSMETICS, 
				true, 
				47.50);

		shoppingBasket.addItem(item1);
		shoppingBasket.addItem(item2);

		Receipt  receipt = new SimpleReceipt(shoppingBasket, taxCalculator);

		System.out.println(receipt.toString());
		System.out.println(receipt.getTotal() == 65.15);
	}
}
