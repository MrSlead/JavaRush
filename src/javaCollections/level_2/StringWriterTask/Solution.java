package javaCollections.level_2.StringWriterTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;                                                  
                                                  
/*                                                   
Читаем из потока                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));                                                  
        System.out.println(writer.toString());                                                  
    }                                                  
                                                  
    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
    	StringWriter sw = new StringWriter();
        if(is != null) {
        	byte bytes [] = new byte[is.available()];
        	is.read(bytes);
        	sw.write(new String(bytes));
        }
        return sw;
    }                                                  
}