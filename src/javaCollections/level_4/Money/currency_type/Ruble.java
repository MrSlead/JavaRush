package javaCollections.level_4.Money.currency_type;

import javaCollections.level_4.Money.Money;

public class Ruble extends Money {
	public Ruble(double amount) {
		super(amount);
	}
	
	@Override
	public String getCurrencyName() {
		return "RUB";
	}

}
