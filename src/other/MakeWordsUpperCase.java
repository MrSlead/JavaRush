package other;

import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;
import java.util.Arrays;                                                  
                                                  
/*                                                   
Омовение Рамы                                                  
*/                                                  
                                                  
public class MakeWordsUpperCase {                                                  
    public static void main(String[] args) throws IOException {                                                  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
        String string = reader.readLine();                                                  
        string = string.trim();                                           
        String words [] = string.split("[ ]+");
        
        Arrays.stream(words).
        forEach(s -> 
        	System.out.print(String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, s.length()) + " "));
    }                                                  
}                                               
                                                  
      