package javaCollections.level_3.JSON6;

import com.fasterxml.jackson.core.JsonProcessingException;                                                  
import com.fasterxml.jackson.databind.ObjectMapper;                                                  
                                                  
/*                                                   
Сериализация зоопарка                                                  
*/                

/*
 * It was: {"animals":[{"name":"doggy","barkVolume":0.0},{"name":"catty","lives":0}]}
 * 
 * Become:
 */
public class Solution {                                                  
    public static void main(String[] args) throws JsonProcessingException {                                                  
        Zoo.Dog dog = new Zoo.Dog("doggy");                                                  
        Zoo.Cat cat = new Zoo.Cat("catty");                                                  
        Zoo zoo = new Zoo();                                                  
        zoo.animals.add(dog);                                                  
        zoo.animals.add(cat);                                                  
                                                  
        String result = new ObjectMapper().writeValueAsString(zoo);                                                  
        String res2 = new ObjectMapper().writeValueAsString(dog);                                          
        System.out.println(result);   
        System.out.println(res2);  
    }                                                  
}