package gquadrati.sales_taxes.models;

public final class ShoppingBasketItem implements Item {

	private String name;
	private String category;
	private boolean isImported;
	private double price;
	//private int quantity;
	
	public ShoppingBasketItem(String name, 
							String category, 
							boolean isImported,
							double price) 
	{
		this.name = name;
		this.category=category;
		this.isImported = isImported;
		this.price = price;	
		//this.quantity = 1;
	}
	
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String GetCategory() {
		return category;
	}

	@Override
	public boolean getIsImported() {
		return isImported;
	}

	@Override
	public double getPrice() {
		return price;
	}
	 

}
