package javaCollections.level_3.JSON_Diserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;                                             

/*                                                   
Десериализация JSON объекта                                                  
*/                                                  
public class Solution {                                                  
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException { 
        File fileReader = new File(fileName);
        ObjectMapper mapper = new ObjectMapper();
        
		return mapper.readValue(fileReader, clazz);
    }                                                  
                                                  
    public static void main(String[] args) throws IOException {                                                  
    }                                                  
}