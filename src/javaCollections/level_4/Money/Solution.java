package javaCollections.level_4.Money;

import java.util.ArrayList;                                                  
import java.util.List;

import javaCollections.level_4.Money.currency_type.Ruble;
import javaCollections.level_4.Money.currency_type.USD;                                                  
                                                  
/*                                                   
Валюты                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        Person ivan = new Person("Иван");      
        ivan.allMoney.add(new Ruble(34));
        ivan.allMoney.add(new USD(153));
        for (Money money : ivan.getAllMoney()) {                                                  
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());                                                  
        }                                                  
    }                                                  
                                                  
    static class Person {                                                  
        public String name;                                                  
                                                  
        Person(String name) {                                                  
            this.name = name;                                                  
            this.allMoney = new ArrayList<Money>();                                                  
            //напишите тут ваш код                                                  
        }                                                  
                                                  
        private List<Money> allMoney;                                                  
                                                  
        public List<Money> getAllMoney() {                                                  
            return allMoney;                                                  
        }                                                  
    }                                                  
}