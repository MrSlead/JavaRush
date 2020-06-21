                                               
import java.io.BufferedReader;                                                  
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;                                                  
                                                  
/*                                                   
���� �����������                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws Exception {                                                  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
        int[] array = new int[20];                                                  
        for (int i = 0; i < array.length; i++) {                                                  
            array[i] = Integer.parseInt(reader.readLine());                                                  
        }                                                  
                                                  
        sort(array);                                                  
                                                  
        System.out.println(array[0]);                                                  
        System.out.println(array[1]);                                                  
        System.out.println(array[2]);                                                  
        System.out.println(array[3]);                                                  
        System.out.println(array[4]);                                                  
    }                                                  
                                                  
    public static void sort(int[] array) {    
    	for (int left = 0; left < array.length; left++) {
    		// ����������� �������� ��������
    		int value = array[left];
    		// ������������ �� ���������, ������� ����� ���������� ���������
    		int i = left - 1;
    		for (; i >= 0; i--) {
    			// ���� �������� �������� ������� � ����������� ������� ������� ������
    			if (value < array[i]) {
    				array[i + 1] = array[i];
    			} else {
    				// ���� ���������� ������� ������ � ���������������
    				break;
    			}
    		}
    		// � �������������� ����� ��������� ���������� ��������
    		array[i + 1] = value;
    	}
    	
    	
    	 if (array == null) {
    	        return;
    	    }
    	    int i = 0;
    	    int j = array.length - 1;
    	    int tmp;
    	    while (j > i) {
    	        tmp = array[j];
    	        array[j] = array[i];
    	        array[i] = tmp;
    	        j--;
    	        i++;
    	    }                                        
    }                                                  
}                                              
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                                                  