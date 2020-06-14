package javaCore.level_4.FactoryHen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaCore.level_4.FactoryHen.hen.BelarusianHen;
import javaCore.level_4.FactoryHen.hen.MoldovanHen;
import javaCore.level_4.FactoryHen.hen.RussianHen;
import javaCore.level_4.FactoryHen.hen.UkrainianHen;

public class Solution {                                                  
    public static void main(String[] args) {                                                  
        List<Hen> listHen = new ArrayList<>(Arrays.asList(
        		HenFactory.getHen(Country.BELARUS),
		        HenFactory.getHen(Country.MOLDOVA),
		        HenFactory.getHen(Country.RUSSIA),
		        HenFactory.getHen(Country.UKRAINE)
		));
        
       listHen.forEach(hen -> System.out.println(hen.getDescription()));                                             
    }                                                  
                                                  
    static class HenFactory {                                                  
                                                  
        static Hen getHen(String country) {                                                  
            Hen hen = null;                                                  
            if(country.equals("Belarus")) {
            	hen = new BelarusianHen();
            }
            else if(country.equals("Russia")) {
            	hen = new RussianHen();
            }
            else if(country.equals("Moldova")) {
            	hen = new MoldovanHen();
            }
            else if(country.equals("Ukraine")) {
            	hen = new UkrainianHen();
            }
            return hen;                                                  
        }                                                  
    }                                                  
                                                  
                                                  
}