package javaCollections.level_3.JSON3;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;                                                  
                                                  
/*                                                   
Конвертация из одного класса в другой используя JSON Ӏ 3304                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        Second s = (Second) convertOneToAnother(new First(), Second.class);                                                  
        First f = (First) convertOneToAnother(new Second(), First.class);                                                  
    }                                                  
                                                  
    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
    	 ObjectMapper mapper = new ObjectMapper();
         String jsonString = mapper.writeValueAsString(one);

         jsonString = jsonString.replaceFirst(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
         
         Reader reader = new StringReader(jsonString);
         return mapper.readValue(reader, resultClassObject);                                             
    }                                                  
                                                  
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")                                                  
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))                                                  
    public static class First {                                                  
        public int i;                                                  
        public String name;  
        
        public First() {
        	
        }
    }                                                  
                                                  
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")                                                  
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))                                                  
    public static class Second {                                                  
        public int i;                                                  
        public String name;     
        
        public Second() {
        	
        }
    }                                                  
}