package javaCollections.level_2.RandomAccessFile2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Solution {

	public static void main(String ... args) throws FileNotFoundException, IOException {
		try(RandomAccessFile outputAdvanced = new RandomAccessFile(args[0], "rw")){
			long number = Long.parseLong(args[1]);
			String text = args[2];
			byte readText [] = new byte[text.length()];
			
			outputAdvanced.seek(number);
			outputAdvanced.read(readText, 0, text.length());
			
			outputAdvanced.seek(outputAdvanced.length());

			if(new String(readText).equals(text)) {
				outputAdvanced.write("true".getBytes());
			}
			else {
				outputAdvanced.write("false".getBytes());
			}
		}
	}

}
