package javaCore.level_9.AnotherAdapter;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Adapter
 */
public class Solution {                                                  
    
    public static void main(String[] args) {                                                  
                                                  
    }                                                  
                                                  
    public static class PersonScannerAdapter implements PersonScanner {
    	private final Scanner fileScanner;
    	
    	public PersonScannerAdapter(Scanner scanner) {
    		this.fileScanner = scanner;
    	}
    	
		@Override
		public Person read() throws IOException {
			String fullInfoPerson [] = fileScanner.nextLine().split(" ");

			return new Person(fullInfoPerson[1], fullInfoPerson[2], fullInfoPerson[0], 
					new GregorianCalendar(
							Integer.parseInt(fullInfoPerson[5]), 
							Integer.parseInt(fullInfoPerson[4]) - 1, 
							Integer.parseInt(fullInfoPerson[3]))
					.getTime());
		}

		@Override
		public void close() throws IOException {
			fileScanner.close();
		}                                                  
                                                  
    }                                                  
}