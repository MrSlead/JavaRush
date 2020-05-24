package javaCore.level_9.ReverseContentInFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws IOException {
		String nameFile = "";
		try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
			nameFile = buffReader.readLine();
		}
		
		try(BufferedReader buffReader = new BufferedReader(new FileReader(nameFile))){
			String line;
			
			while((line = buffReader.readLine()) != null) {
				System.out.println(new StringBuffer(line).reverse());
			}
		}
	}
}
