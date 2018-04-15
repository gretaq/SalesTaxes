package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.models.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimpleItemTaxCalculatorTest {

	SimpleItemTaxCalculator calc;

	@Parameter
	public int id;
	@Parameter(1)
	public String name;
	@Parameter(2)
	public String category;
	@Parameter(3)
	public boolean isImported;
	@Parameter(4)
	public double price;
	
	@Parameter(5)
	public double expectedResult;

	
	@Parameters(name = "Test New [{index}] : {1} - {3} -> {4}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
			
				//Tax-free test
				{1, "", SimpleItemConfiguration.CAT_BOOK, false, 3.5, 0.0 },
				{2, "", SimpleItemConfiguration.CAT_BOOK, true, 3.5, 0.2 } ,
				
				//no Tax-free test
				{3, "", SimpleItemConfiguration.CAT_COSMETICS, false, 5.2, 0.55 } ,
				{4, "", SimpleItemConfiguration.CAT_COSMETICS, true, 5.2, 0.85 }
				});
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

		Item item = new ShoppingBasketItem(id, name, category, isImported, price);

		double tax = calc.calculateTaxesFor(item);
		assertTrue(expectedResult == tax);
	}


}
