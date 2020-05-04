package javaCore.level_8.RoundingDoubleInFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
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
