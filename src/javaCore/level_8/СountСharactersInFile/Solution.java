package javaCore.level_8.—ount—haractersInFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		try(BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\test.txt"))){
			SortedMap<Character, Integer> map = new TreeMap<>();
			String line;
			while((line = buffReader.readLine()) != null) {
				char charsInLine [] = line.toCharArray();
				
				for(int i = 0; i < charsInLine.length; i++) 
					map.merge(charsInLine[i], 1, (a, b) -> (a+1));
				
				
				map.forEach((k, v) -> System.out.println(k + " " + v));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
