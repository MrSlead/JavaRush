package javaCore.level_10.IntroductionProperties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * Loading and saving info from a file.properties
 */

public class Solution {                                                  
                                                  
    public static Map<String, String> runtimeStorage = new HashMap<>();                                                  
                                                  
    public static void save(OutputStream outputStream) throws Exception {                                                  
    	Properties prop = new Properties();
    	
    	runtimeStorage.forEach((k, v) -> prop.setProperty(k, v));
    	prop.store(outputStream, null);
    }                                                  
                                                  
    public static void load(InputStream inputStream) throws IOException {                                                  
    	Properties prop = new Properties();
    	
    	prop.load(inputStream);
    	Enumeration<?> enumeration = prop.propertyNames();
    	while(enumeration.hasMoreElements()) {
    		String element = (String) enumeration.nextElement();
    		runtimeStorage.put(element, prop.getProperty(element));
    	}
    }                                                  
                                                  
    public static void main(String[] args) throws IOException {                                                  
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
             FileInputStream fos = new FileInputStream(reader.readLine())) {                                                  
            load(fos);
        } catch (IOException e) {                                                  
            e.printStackTrace();                                                  
        }                                                  
                                                  
        System.out.println(runtimeStorage); 
    }                                                  
}