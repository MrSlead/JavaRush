package javaCollections.level_4.Factorial;

/*                                                   
��������� � ������� ��������                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        Solution solution = new Solution();                                                  
                                                  
        System.out.println(solution.factorial(9));     //362880                                                  
        System.out.println(solution.factorial(0));     //1                                                  
        System.out.println(solution.factorial(1));     //1  
    }                                                  
                                                  
    public int factorial(int n) {    
    	if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        return factorial(n-1)*n;
    }                                                  
} 