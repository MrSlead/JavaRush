package javaCore.level_9.MineReader2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {                                                  
    public static TestString testString = new TestString();                                                  
                                                  
    public static void main(String[] args) {                                                  
       PrintStream consoleStream = System.out;
       
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       
       PrintStream stream = new PrintStream(outputStream);
       
       System.setOut(stream);
       
       testString.printSomething();
       String modifiedStroke = outputStream.toString().replaceAll("te", "??");
       
       System.setOut(consoleStream);
       
       System.out.println(modifiedStroke); // it's a ??xt for ??sting
    }                                                  
                                                  
    public static class TestString {                                                  
        public void printSomething() {                                                  
            System.out.println("it's a text for testing");                                                  
        }                                                  
    }                                                  
}