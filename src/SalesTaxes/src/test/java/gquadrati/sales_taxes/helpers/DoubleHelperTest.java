package gquadrati.sales_taxes.helpers;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DoubleHelperTest {
	
	@Parameter 
    public double value;	
	@Parameter(1)
	public double multipleOfNumber;  
	@Parameter(2)
	public double acceptedResult;
	
    
    @Parameters(name = "Test New [{index}] : {0} -> {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { 0.00, 0.05,  0.00},
                 { 0.01, 0.05, 0.05},
                 { 0.02, 0.05, 0.05},
                 { 0.03, 0.05, 0.05},
                 { 0.04, 0.05, 0.05},
                 { 0.05, 0.05, 0.05},
                 { 0.06, 0.05, 0.1},
                 { 0.07, 0.05, 0.1},
                 { 0.08, 0.05, 0.1},
                 { 0.09, 0.05, 0.1},
                 { 0.99, 0.05, 1}
           });
    }
        
	
	@Test
	public void canRoundWellToNumberMultiple()
	{
		double round = DoubleHelper.RoundToTheNearestValue(this.value, this.multipleOfNumber);
		assertTrue(round == acceptedResult);
	}

	
}
