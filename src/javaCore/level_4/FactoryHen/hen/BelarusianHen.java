package javaCore.level_4.FactoryHen.hen;

import javaCore.level_4.FactoryHen.Hen;

public class BelarusianHen extends Hen {
	public String getDescription() {
		return super.getDescription() + "Моя страна - Беларусь. Я несу " + getCountOfEggsPerMonth() +
				" яиц в месяц.";
	}
	@Override
	public int getCountOfEggsPerMonth() {
		return 30;
	}

}
