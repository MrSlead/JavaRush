package javaCore.level_9.MineReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/*
 * Useful for logging, for example writing to a file.
 */
public class Solution {                                                  
    public static TestString testString = new TestString();                                                  
                                                  
    public static void main(String[] args) {                                                  
       PrintStream consoleStream = System.out;
       
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       
       PrintStream stream = new PrintStream(outputStream);
       
       System.setOut(stream);
       
       testString.printSomething();
       String modifiedStroke = outputStream.toString().toUpperCase();
       
       System.setOut(consoleStream);
       
       System.out.println(modifiedStroke); // IT'S A TEXT FOR TESTING
    }                                                  
                                                  
    public static class TestString {                                                  
        public void printSomething() {                                                  
            System.out.println("it's a text for testing");                                                  
        }                                                  
    }                                                  
}