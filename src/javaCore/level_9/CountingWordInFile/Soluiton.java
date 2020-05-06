package javaCore.level_9.CountingWordInFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Finding word and counting her.
 */


public class Soluiton {
	private static int count = 0;
	
	public static void main(String[] args) throws IOException {
		String requiredWord = "word";
		String nameFileRead;
		
		try(BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in))){
			nameFileRead = buffRead.readLine();
		}
		
		// FileReader for validator
		try(FileReader fileReader = new FileReader(nameFileRead)){
			Files.lines(Paths.get(nameFileRead)).
			forEach(s -> {
				String[] wordsInLine = s.split("[\\x20-\\x2F-\\x3A-\\x40-\\x5B-\\x60-\\x7B-\\x7E]");
				for(String word : wordsInLine) 
					if(word.toLowerCase().equals(requiredWord)) count++;		
			});
		}
		
		System.out.println(count);

	}

}
