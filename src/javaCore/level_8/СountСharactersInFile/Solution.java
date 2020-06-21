package javaCore.level_8.—ount—haractersInFile;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * Counting characters in a file.
 */

public class Solution {

	public static void main(String[] args) {
		try(FileReader fileReader = new FileReader(args[0])){
			TreeMap<Character, Integer> map = new TreeMap<>();
			int ch;
			
			while((ch = fileReader.read()) != -1) 
				map.merge((char)ch, 1, (a, b) -> (a+1));	
			
			map.forEach((k, v) -> System.out.println((char)k + " " + v));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
