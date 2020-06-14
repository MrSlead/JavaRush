package javaCollections.level_4.Money.currency_type;

import javaCollections.level_4.Money.Money;

public class Hrivna extends Money {
	public Hrivna(double amount) {
		super(amount);
	}
	
	@Override
	public String getCurrencyName() {
		return "UAH";
	}

}
