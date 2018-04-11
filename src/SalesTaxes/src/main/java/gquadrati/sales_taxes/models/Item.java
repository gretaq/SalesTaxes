package gquadrati.sales_taxes.models;

public interface Item {

	public String getName();
		
	public String GetCategory();
	
	public boolean getIsImported();
	
	public double getPrice();
	
	//TODO
	//public float getQuantity();
	
}
