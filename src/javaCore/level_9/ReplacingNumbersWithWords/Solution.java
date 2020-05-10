package javaCore.level_9.ReplacingNumbersWithWords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;                                                  
                                                  
/*
 * Reads the contents of a file and converts numbers to words..
 */
                                                  
public class Solution {                                                  
    public static Map<Integer, String> map = new HashMap<Integer, String>();    
    
    static {
    	String numericWords [] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь",
    			"восемь", "девять", "десять", "одиннадцать", "двенадцать"};
    	for(int i = 0; i <= 12; i++)
    		map.put(i, numericWords[i]);
    }
    
                                                  
    public static void main(String[] args) {       
    	String nameFile = "";
        try(BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in))){
        	nameFile = buffRead.readLine();
        } 
        catch (IOException e) {
			e.printStackTrace();
		}
        
        
    	String output = "";
        try(FileReader fileReader = new FileReader(nameFile)){
        	while(fileReader.ready()) output += (char) fileReader.read();
        } 
        catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
        catch (IOException e) {
			e.printStackTrace();
		}
        
        Pattern patternSearchNumber = Pattern.compile("[0-9]+");
        Pattern patternWords = Pattern.compile("[a-zA-Z_а-яА-Я]");
        Matcher matcherSearchNumber = patternSearchNumber.matcher(output);
        
        while(matcherSearchNumber.find()) {
        	String findNumber = output.substring(matcherSearchNumber.start(), matcherSearchNumber.end());
        	
        	int start = matcherSearchNumber.start();
        	int end = matcherSearchNumber.end();
        	
        	String checkFindNumberOnWord = output.substring(start + (start != 0 ? -1 : 0), end + (end != output.length() ? 1 : 0));
        	Matcher matcherWords = patternWords.matcher(checkFindNumberOnWord);
        	
        	int number = Integer.parseInt(findNumber);
        	
        	if(map.containsKey(number) && !matcherWords.find()) {
        		output = output.substring(0, matcherSearchNumber.start()) + 
        				map.get(number) +
        				output.substring(matcherSearchNumber.start() + ((number > 9) ? 2 : 1), output.length());
        		matcherSearchNumber = patternSearchNumber.matcher(output);
        	}
        }
        System.out.println(output);
    }                                                  
}