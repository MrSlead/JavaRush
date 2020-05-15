package javaCollections.level_1.GeneralInformationAboutDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
	public static void main(String [] args) throws IOException {
		try(Scanner input = new Scanner(System.in)){
			Path directory = Paths.get(input.nextLine());
			
			if(!Files.isDirectory(directory)) {
				System.out.println(directory.toAbsolutePath().toString() + " - не папка");
			}
			else {
				FileVisitorSearch fileVisitorSearch = new FileVisitorSearch();
				
				Files.walkFileTree(directory, fileVisitorSearch);
				
				System.out.println("Всего папок - " + fileVisitorSearch.getCountDirectory());
				System.out.println("Всего файлов - " + fileVisitorSearch.getCountFile());
				System.out.println("Общий размер - " + fileVisitorSearch.getSizeDirectory());
			}
		}
	}
}
