package javaCore.level_8.RoundingDoubleInFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Read 2 files.
 * The first file contains real numbers.
 * Reading the contents of the file.
 * Write rounded numbers to the second file using the 'Math.round' method.
 */

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
		scanner = new Scanner(System.in);
		
		String fileReader = scanner.nextLine();
		String fileWriter = scanner.nextLine();
		
		List<Long> list = Files.lines(Paths.get(fileReader))
				.map(x -> Math.round(Double.parseDouble(x)))
				.collect(Collectors.toList());
		
		
		try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fileWriter))){
			list.stream().forEach(x -> {
				try {
					buffWriter.write(String.valueOf(x + " "));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}

	}

}
