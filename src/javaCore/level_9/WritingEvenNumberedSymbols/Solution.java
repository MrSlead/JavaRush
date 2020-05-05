package javaCore.level_9.WritingEvenNumberedSymbols;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Writing even-numbered symbols in file.
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		String readFile, writeFile;
		try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
			readFile = buffReader.readLine();
			writeFile = buffReader.readLine();		
			
		}
		
		try(FileReader fileReader = new FileReader(readFile); 
			FileWriter fileWriter = new FileWriter(writeFile)){
				boolean flag = false;
				while(fileReader.ready()) {
					int symb = fileReader.read();
					if(flag) {
						fileWriter.write(symb);
						flag = false;
					} else flag = true;
				}
		} 
	}

}
