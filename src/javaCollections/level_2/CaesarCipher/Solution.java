package javaCollections.level_2.CaesarCipher;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;                                                  
                                                  
/*                                                   
Шифр Цезаря                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");                                                  
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0                                                  
    }                                                  
                                                  
    public static String decode(StringReader reader, int key) throws IOException {  
        if(reader != null) {
        	char symbols [];
        	StringWriter sw = new StringWriter();
        	
        	int ch;
        	while((ch = reader.read()) > 0); {
        		sw.write(ch);
        	} 
        	
        	symbols = new String(sw.toString()).toCharArray();
        	for(int i = 0; i < symbols.length; i++) {
        		symbols[i] = (char)((int)symbols[i] + key);
        	}
        	return new String(symbols);
        }
        return new String("");                                                 
    }                                                  
}