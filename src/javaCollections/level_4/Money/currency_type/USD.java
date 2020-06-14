package javaCollections.level_4.Money.currency_type;

import javaCollections.level_4.Money.Money;

public class USD extends Money {
	public USD(double amount) {
		super(amount);
	}
	
	@Override
	public String getCurrencyName() {
		return "USD";
	}

}
