package javaCollections.level_4.Logging;

import org.slf4j.Logger;                                                  
import org.slf4j.LoggerFactory;                                                                                                   
import java.util.Date;                                                  
                                                  
/*                                                   
Добавление логирования в класс                                                  
*/                                                  
                                                  
public class Solution {                                                  
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);                                                  
                                                  
    private int value1;                                                  
    private String value2;                                                  
    private Date value3;                                                  
                                                  
    public Solution(int value1, String value2, Date value3) {  
    	System.out.println(5);
    	logger.debug("constructor Soution: this.value1 = value1\n this.value2 = value2\n this.value3 = value3");
        this.value1 = value1;                                                  
        this.value2 = value2;                                                  
        this.value3 = value3;                                                  
    }                                                  
                                                  
    public static void main(String[] args) {  
    	logger.info("start method main");
    	//Solution sol = new Solution(1, "2", new Date());
    	//sol.divide(4, 2);
    }                                                  
                                                  
    public void calculateAndSetValue3(long value) {
    	logger.trace("start method calculateAndSetValue3");
        value -= 133;                                                  
        if (value > Integer.MAX_VALUE) { 
            value1 = (int) (value / Integer.MAX_VALUE); 
            logger.debug("calculateAndSetValue3: value1 = (int) value / Integer.MAX_VALUE");
        } else {
            value1 = (int) value; 
        	logger.debug("calculateAndSetValue3: value1 = (int) value");
        }                                                  
    }                                                  
                                                  
    public void printString() { 
    	logger.trace("start method printString");
        if (value2 != null) {                                                  
            System.out.println(value2.length());                                                  
        }                                                  
    }                                                  
                                                  
    public void printDateAsLong() {  
    	logger.trace("start method printDateAsLong");
        if (value3 != null) {                                                  
            System.out.println(value3.getTime());                                                  
        }                                                  
    }                                                  
                                                  
    public void divide(int number1, int number2) { 
    	logger.trace("start method divide");
        try {              
        	logger.debug("divide: number1 / number2 in System.out.println");
            System.out.println(number1 / number2);                                                  
        } catch (ArithmeticException e) {    
        	logger.error("divide by zero | method divide");
        }                                                  
    }                                                  
                                                  
    public void setValue1(int value1) {
    	logger.debug("setValue1: this.value1 = value1");
        this.value1 = value1;                                                  
    }                                                  
                                                  
    public void setValue2(String value2) { 
    	logger.debug("setValue2: this.value2 = value2");
        this.value2 = value2;                                                  
    }                                                  
                                                  
    public void setValue3(Date value3) {
    	logger.debug("setValue3: this.value3 = value3");
        this.value3 = value3;                                                  
    }                                                  
} 