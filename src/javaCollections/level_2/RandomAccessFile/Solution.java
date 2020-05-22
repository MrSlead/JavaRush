package javaCollections.level_2.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
	public static void main(String ... args ) throws FileNotFoundException, IOException {
		try(RandomAccessFile outputAdvanced = new RandomAccessFile(args[0], "rw")){
			long number = Long.parseLong(args[1]);
			
			if(outputAdvanced.length() < number) {
				number = outputAdvanced.length();
			}
			outputAdvanced.seek(number);
			outputAdvanced.write(args[2].getBytes());
		}
	}
}
