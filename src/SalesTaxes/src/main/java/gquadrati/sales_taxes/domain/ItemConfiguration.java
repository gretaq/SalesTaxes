package gquadrati.sales_taxes.domain;

import gquadrati.sales_taxes.models.Item;


public interface ItemConfiguration {

	
	public boolean isTaxFree(Item item);
}
