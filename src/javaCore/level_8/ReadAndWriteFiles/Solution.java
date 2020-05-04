package javaCore.level_8.ReadAndWriteFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Read 3 files. 
 * Write the contents of the second file to the first file.
 * And add the contents of the third file to the first file.
 */

public class Solution {
	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		String files[] = new String[3];
		for(int i = 0; i < files.length; i++)
			files[i] = scanner.nextLine();
		
		List<String> list = readFile(files[1], files[2]);
		
		writeFile(list, files[0]);
	}
	
	public static List<String> readFile(String... wayNameFile) throws IOException {
		List<String> generalList = new ArrayList<>();
		for(int i = 0; i < wayNameFile.length; i++) {
			List<String> list = Files.lines(Paths.get(wayNameFile[i]), Charset.forName("windows-1251")).collect(Collectors.toList());
			list.forEach(generalList::add);
		}
		return generalList;
	}
	
	public static void writeFile(List<String> list, String wayNameFile) throws IOException {
		try(BufferedWriter buffWrite = new BufferedWriter(new FileWriter(wayNameFile))){
			list.stream().forEach(s -> {
				try {
					buffWrite.write(s);
					buffWrite.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
