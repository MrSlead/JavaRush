package javaCore.level_9.MineReader3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {                                                  
    public static TestString testString = new TestString();                                                  
                                                  
    public static void main(String[] args) {  
    	PrintStream consoleStream = System.out;
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        PrintStream stream = new PrintStream(outputStream);
        
        System.setOut(stream);
        
        testString.printSomething();
        // 1 way
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(outputStream.toString());
        String newStroke = "";
        while(matcher.find())
        	newStroke += outputStream.toString().substring(matcher.start(), matcher.end());
        
        System.setOut(consoleStream);
        
        System.out.println(newStroke); // 12345678
        // 2 way
        //System.out.println(outputStream.toString().replaceAll("[^0-9]", "")); 
    }                                                  
                                                  
    public static class TestString {                                                  
        public void printSomething() {                                                  
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");                                                  
        }                                                  
    }                                                  
}