package javaCore.level_9.InfoPersonInFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Info is read from the file according to the following principle: [name] [day] [month] [year].
 * And adding info to PEOPLE.                                                 
 */
                                                  
public class Solution {                                                  
    public final static List<Person> PEOPLE = new ArrayList<Person>();                                                
                                             
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(BufferedReader buffRead = new BufferedReader(new FileReader(args[0]))){
        	buffRead.lines().forEach(s -> {
        		Pattern pattern = Pattern.compile("[^0-9]+");
        		Matcher matcher = pattern.matcher(s);
        		
        		matcher.find();
        		String name = s.substring(matcher.start(), matcher.end()).trim();
        		
        		String birthDay = s.substring(name.length()+1, s.length());
        		String [] birthDayString = birthDay.split(" ");
        		
        		PEOPLE.add(new Person(name, new GregorianCalendar(
        				Integer.parseInt(birthDayString[2]),
        				Integer.parseInt(birthDayString[1])-1,
        				Integer.parseInt(birthDayString[0]))
        				.getTime()));
        	});
        }
        // For example sorting
        /*
        Comparator<Person> comparator = new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
        };
        
        Collections.sort(PEOPLE, comparator);*/
    }
}
