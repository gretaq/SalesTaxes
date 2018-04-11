package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.domain.*;
import gquadrati.sales_taxes.models.*;

import static org.junit.Assert.*;

import org.junit.*;

public class SimpleItemTaxCalculatorTests {

	SimpleItemTaxCalculator calc;

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
	}

	@Before
	public void setUp() {
		calc = new SimpleItemTaxCalculator(new SimpleItemConfiguration());
	}

	@After
	public void tearDown() {
	}

	@Test
	public void TestBookTax() {

		Item item = new ShoppingBasketItem("", SimpleItemConfiguration.CAT_BOOK, false, 3.5);

		double tax = calc.calculateTaxesFor(item);
		assertTrue(0.0 == tax);
	}

	@Test
	public void TestImportedBookTax() {

		Item item = new ShoppingBasketItem("", SimpleItemConfiguration.CAT_BOOK, true, 3.5);

		double tax = calc.calculateTaxesFor(item);
		assertTrue(0.2 == tax);
	}

}
