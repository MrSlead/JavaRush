package javaCollections.level_3.JAXB3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
	private Goods goods;
	private double profit;
	private int count;
	private String [] secretData;
	
	
	
	@XmlType(name = "goods")
	@XmlRootElement
	public static class Goods {
		
		@XmlElement(name = "names")
		private List<String> names;
		
		public void setNames(String ... s) {
			if(names == null) names = new ArrayList<>();
			names.addAll(Arrays.asList(s));
		}
	}

	
	
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public void setSecretData(String[] secretData) {
		this.secretData = secretData;
	}

	public Goods getGoods() {
		return goods;
	}

	public int getCount() {
		return count;
	}

	public double getProfit() {
		return profit;
	}

	public String[] getSecretData() {
		return secretData;
	}
}
