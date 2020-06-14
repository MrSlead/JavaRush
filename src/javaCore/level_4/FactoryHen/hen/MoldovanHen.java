package javaCore.level_4.FactoryHen.hen;

import javaCore.level_4.FactoryHen.Hen;

public class MoldovanHen extends Hen {
	public String getDescription() {
		return super.getDescription() + "Моя страна - Молдавия. Я несу " + getCountOfEggsPerMonth() +
				" яиц в месяц.";
	}
	@Override
	public int getCountOfEggsPerMonth() {
		return 31;
	}

}
