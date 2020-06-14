package javaCollections.level_3.JAXB4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/*                                                   
Комментарий внутри xml                                                  
*/                                                  
public class Solution {                                                  
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {                                                  
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        StringReader reader = new StringReader("");
        unmarshaller.unmarshal(reader);
        
        String xmlFormat = new String(reader.toString());                                                 
        
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(String.format("<%s?>", tagName));
        Matcher matcher;
        
        try(BufferedReader buffReader = new BufferedReader(reader)){
        	String line;
        	
        	while((line = buffReader.readLine()) != null) {
        		matcher = pattern.matcher(line);
        		if(matcher != null && matcher.find()) {
        			list.add("<!--"+ comment + "-->");
        			list.add(line);
        		}
        		else {
        			list.add(line);
        		}
        	}
        }
        String res = "";
        for(String s : list) {
        	res = res + s;
        }
        return res;
    }                                                  
                                                  
    public static void main(String[] args) throws JAXBException, IOException {                                                  
          toXmlWithComment(new Object(), "secretData", "HEHEHEH");                                        
    }                                                  
}