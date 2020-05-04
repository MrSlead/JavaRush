package javaCore.level_8.Space;


/**
 * Calculate the number of spaces and find the ratio of spaces to all characters
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) {
		try(BufferedReader buffRead = new BufferedReader(new FileReader(args[0]))){
			String line;
			int countSpace = 0;
			int allSymbols = 0;
			
			while((line = buffRead.readLine()) != null) {
				allSymbols += line.length();
				if(line.contains(" ")) {
					while(true) {
						countSpace++;
						line = line.substring(line.indexOf(' ') + 1);
						if(!line.contains(" ")) break;
					}
				}
			}
			System.out.printf("%.2f", ((float)countSpace / allSymbols * 100));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
