package javaCollections.level_2.StringWriter2;

import java.io.PrintWriter;
import java.io.StringWriter;

/*                                                   
Пишем стек-трейс                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));                                                  
        System.out.println(text);                                                  
    }                                                  
                                                  
    public static String getStackTrace(Throwable throwable) {
    	StringWriter sw = new StringWriter();
    	PrintWriter printWriter = new PrintWriter(sw);
    	throwable.printStackTrace(printWriter);
    	
        return sw.toString();                                                  
    }                                                  
}