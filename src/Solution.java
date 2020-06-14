import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {                                                  
    public static void main(String[] args) {   
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        	int one = Integer.parseInt(br.readLine());
        	int two = Integer.parseInt(br.readLine());
        	
        	if(one <= 0 || two <= 0) throw new Exception();
        	System.out.println(gcd(one, two));
        } catch (Exception e) {
        	e.printStackTrace();
        }
    } 
    
    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}