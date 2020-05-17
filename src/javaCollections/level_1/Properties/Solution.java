package javaCollections.level_1.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;                                                  

/*                                                   
Читаем конфиги                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        Solution solution = new Solution();                                                  
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");                                                  
        properties.list(System.out);                                                  
                                                  
        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");                                                  
        properties.list(System.out);                                                  
                                                  
        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");                                                  
        properties.list(System.out); 
    }                                                  
                                                  
    public Properties getProperties(String fileName) {                                                  
    	Properties properties = new Properties();
    	Path file = Paths.get(fileName);
    	
    	try(FileInputStream input = new FileInputStream(file.toFile())) {
    		if(fileName.endsWith(".xml")) {
    			properties.loadFromXML(input);
    		}
    		else {
    			properties.load(input);
    		}
			
		} catch (IOException e) {
			properties = new NotNullProperties(e);
		}
    	return properties;
    }       
    
    class NotNullProperties extends Properties {
		private static final long serialVersionUID = 1L;
		private Exception e;
    	
    	public NotNullProperties(Exception e) {
    		this.e = e;
    	}
    	
    	public Exception getException() {
    		return e;
    	}
    }
}
