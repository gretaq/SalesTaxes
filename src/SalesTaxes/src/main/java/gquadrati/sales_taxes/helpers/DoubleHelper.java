package gquadrati.sales_taxes.helpers;

/**
 * @author Greta Quadrati
 *
 *         Helper for rounding decimals
 */
public final class DoubleHelper {

	
	/**
	 *  Since the class must not be initialized, 
	 *  we put the constructor private.
	 */
	private DoubleHelper() {
	}

	
	/**
	 * @param value The value to round
	 * @param decimalsNumber maximum number of decimal values
	 * @return The number truncated at decimals with rounding up the initial value
	 */
	public static double RoundingUp(double value, int decimalsNumber) {
		double temp = Math.pow(10, decimalsNumber);
		return Math.round(value * temp) / temp;
	}

	
	/**
	 * @param value The value to round
	 * @param roundToMultiple the number to which multiple round up the value
	 * @return the value rounded up to the nearest multiple of roundToMultiple parameter
	 */
	public static double RoundToTheNearestValue(double value, double roundToMultiple) {
		double val = Math.ceil(value / roundToMultiple) * roundToMultiple;
		return val;
	}
}
