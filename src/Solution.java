import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;                                                  
                                                  
/*                                                   
Факториал                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {   
    	int width = 3;
    	int height = 3;
    	int matrix [][] = new int[height][width];
    	for(int i = 0; i < width; i++) {
    		matrix[height-1][i] = 1;
    		matrix[height-2][i] = 1;
    	}
		matrix[height-3][0] = 1;
		matrix[height-3][2] = 1;
		matrix[height-2][2] = 0;
    	for(int j = 0; j < height; j++) {
	    	int count = 0;
	        for(int i = 0; i < width; i++) {
	        	if(matrix[height-1][i] != 0) {
	        		count++;
	        	}
	        }
	        
	        if(count == width) {
	        	for(int i = height - 2; i >= 0; i--) {
	        		matrix[i+1] = Arrays.copyOfRange(matrix[i], 0, width);
	        	}
	        	for(int i = 0; i < width; i++) {
	        		matrix[0][i] = 0;
	        	}
        		
	        }        
    	}
    	
    	 for (int i = 0; i < height; i++) {                                                  
             for (int j = 0; j < width; j++) {                                                  
                 int index = matrix[i][j];                                                  
                 if (index == 0)                                                  
                     System.out.print(" . ");                                                  
                 else if (index == 1)                                                  
                     System.out.print(" X ");                                                  
                 else if (index == 2)                                                  
                     System.out.print(" X ");                                                  
                 else                                                  
                     System.out.print("???");                                                  
             }                                                  
             System.out.println();                                                  
         }                     
    }                                                                                                                                
}