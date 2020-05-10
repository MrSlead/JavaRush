package javaCore.level_9.ComparingTextFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;                                                  
import java.util.List;                                                  
                                                  
/*
 * Not finished.                                        
 */
                                                  
public class Solution {                                                  
    public static List<LineItem> lines = new ArrayList<LineItem>();                                                  
                                                  
    public static void main(String[] args) {  
    	String file = "", newFile = "";
    	
    	//try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
    		file = "C:\\Users\\Кокон2\\Desktop\\test.txt";//buffReader.readLine();
    		newFile = "C:\\Users\\Кокон2\\Desktop\\t.txt";//buffReader.readLine();
    	/*} catch (IOException e) {
			e.printStackTrace();
		}*/
    	
    	try(BufferedReader buffReaderFile = new BufferedReader(new FileReader(file));
    		BufferedReader buffReaderNewFile = new BufferedReader(new FileReader(newFile))){
    		
    		String lineFile = "", lineNewFile = "";
			String lineNewFileNext = "";
    		boolean isSame = true;
    		boolean isDeleted = false;
    		
    		
    		while(buffReaderNewFile.ready()) {	
    			lineFile = buffReaderFile.readLine();
    			if(!isDeleted) {
    				if(lineNewFileNext.equals(""))
    					if(buffReaderNewFile.ready())
    						lineNewFile = buffReaderNewFile.readLine();
    					else {
        					lines.add(new LineItem(Type.REMOVED, lineFile));
        					break;
        				}
    				else lineNewFileNext = "";
    			}
    			
    			if(lineNewFile.equals(lineFile)) {
    				lines.add(new LineItem(Type.SAME, lineNewFile));
    				isSame = true;
    				if(isDeleted) {
    					isDeleted = false;
    					lineNewFile = lineNewFileNext;
    				}
    			}
    			
    			else if(isSame) {
    				if(buffReaderNewFile.ready()) 
    					lineNewFileNext = buffReaderNewFile.readLine();
    				else {
    					lines.add(new LineItem(Type.REMOVED, lineFile));
    					break;
    				}
    				
    				if(lineNewFileNext.equals(lineFile)) {
    					lines.add(new LineItem(Type.ADDED, lineNewFile));
    					lines.add(new LineItem(Type.SAME, lineNewFileNext));
    					isSame = true;
    					lineNewFileNext = "";
    				}
    				else  {
    					lines.add(new LineItem(Type.REMOVED, lineFile));
    					isDeleted = true;
    					isSame = false;
    				}
    			}	
    		}
    		
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	lines.forEach(li -> System.out.println("Type: " + li.type + ". Stroke: " + li.line));
    }    
    
                                                  
                                                  
    public static enum Type {                                                  
        ADDED,        //добавлена новая строка                                                  
        REMOVED,      //удалена строка                                                  
        SAME          //без изменений                                                  
    }                                                  
                                                  
    public static class LineItem {                                                  
        public Type type;                                                  
        public String line;                                                  
                                                  
        public LineItem(Type type, String line) {                                                  
            this.type = type;                                                  
            this.line = line;                                                  
        }                                                  
    }                                                  
}