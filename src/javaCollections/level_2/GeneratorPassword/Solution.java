package javaCollections.level_2.GeneratorPassword;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;                                                  

/*                                                   
Генератор паролей                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException { 
	        ByteArrayOutputStream password = getPassword();  
	        System.out.println(password.toString());
	        //System.out.println(password.toString().length());
    }                                                  
                                                  
    public static ByteArrayOutputStream getPassword() throws IOException {  
    	String alphabetLowerCase = "qwertyuiopasdfghjklzxcvbnm";
    	String alphabetUpperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
    	String numbers = "0123456789";
    	String password = "";
    	
    	int lengthPassword = 8;
    	int free = lengthPassword;
        List<Character> passwordSymbols = new ArrayList<>(free);
        
        
        int closed = (int)(Math.random() * (free - 2)+1);
        for(int i = 0; i < closed; i++) {
        	passwordSymbols.add(alphabetLowerCase.charAt((int) (Math.random() * alphabetLowerCase.length())));
        }
        if(closed == 0) free--;
        else free = free - closed;
        
       
        int closed2 = (int)(Math.random() * (free - 1)+1);
        for(int i = 0; i < closed2; i++) {
        	passwordSymbols.add(alphabetUpperCase.charAt((int) (Math.random() * alphabetUpperCase.length())));
        }
        if(closed2 == 0) free--;
        else free = free - closed2;
        
        for(int i = 0; i < free; i++) {
        	passwordSymbols.add(numbers.charAt((int) (Math.random() * numbers.length())));
        }
        
        for(int i = 0; i < lengthPassword; i++) {
        	int index = (int) (Math.random() * passwordSymbols.size());
        	password += passwordSymbols.remove(index);
        }
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(password.getBytes());
        
        return output;
    }                                                  
}