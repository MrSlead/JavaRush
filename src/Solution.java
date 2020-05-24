import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;
import java.math.BigInteger;                                                  
                                                  
/*                                                   
Факториал                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {                                                  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
                                                  
        int input = Integer.parseInt(reader.readLine());                                                  
        reader.close();                                                  
                                                  
        System.out.println(factorial(input));                                                  
    }                                                  
                                                  
    public static String factorial(int n) {
        if(n == 0) return String.valueOf(1);
        else if(n < 0) return String.valueOf(0);
        BigInteger fac = new BigInteger("1");                                             
        for(int i = 1; i <= n; i++){
            fac = fac.multiply(new BigInteger(String.valueOf(i)));
        }                                                   
                                                  
        return String.valueOf(fac.toString());                                                  
    }                                                  
}