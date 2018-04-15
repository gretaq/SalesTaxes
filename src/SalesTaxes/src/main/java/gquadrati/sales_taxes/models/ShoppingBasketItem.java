package gquadrati.sales_taxes.models;

public final class ShoppingBasketItem implements Item {

	private int id;
	private String name;
	private String category;
	private boolean isImported;
	private double price;

	/**
	 * Base constructor
	 */
	public ShoppingBasketItem(int id, String name, String category, boolean isImported, double price) {

		this.id = id;
		this.name = name;
		this.category = category;
		this.isImported = isImported;
		this.price = price;
	}

	@Override
	public int getId() {
		return id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		result = prime * result + (isImported ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ShoppingBasketItem other = (ShoppingBasketItem) obj;
		
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (isImported != other.isImported)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
