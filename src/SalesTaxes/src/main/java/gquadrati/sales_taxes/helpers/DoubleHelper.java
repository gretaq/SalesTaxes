package gquadrati.sales_taxes.helpers;

public final class DoubleHelper {


	private DoubleHelper(){}

	public static double RoundingUp(double value, int decimalsNumber) {
		double temp = Math.pow(10, decimalsNumber);
		return Math.round(value * temp) / temp;
	}
	
	
	public static double RoundingDown(double value, int decimalsNumber) {
		double temp = Math.pow(10, decimalsNumber);
		return Math.round(value * temp) / temp;
	}

	
	
	
	public static double RoundToTheNearestValue(double value, double roundToMultiple)
	{
		double val =  Math.ceil(value / roundToMultiple) * roundToMultiple;
		return val;
	}
}
