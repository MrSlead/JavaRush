package javaCore.level_9.ReverseContentInFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
	public static void main(String [] args) throws IOException {	
		try(BufferedReader buffReader = new BufferedReader(new FileReader(args[0])); 
			FileWriter fileWriter = new FileWriter(args[1])){
			String line;
			
			while((line = buffReader.readLine()) != null) {
				String words [] = line.split(" ");
				for(String s : words) {
					if(s.length() > 6) {
						if(!buffReader.ready() && words[words.length - 1] == s) {
							fileWriter.write(s);
						}
						else {
							fileWriter.write(s + ",");
						}
					}
				}
			}
		}
	}
}
