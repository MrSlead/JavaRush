package javaCore.level_10.LikenessSerialization;                                                 

import java.util.*;
import java.io.*;
                                                  
/*
 * Read information from the file and write it to Human.                                                 
 */
public class Solution {                                                  
    public static void main(String[] args) {                                                                                                    
        try {                                                  
            //File your_file_name = File.createTempFile("your_file_name", null);                                                  
            OutputStream outputStream = new FileOutputStream("C:\\Users\\�����2\\Desktop\\st.properties");                                                  
            InputStream inputStream = new FileInputStream("C:\\Users\\�����2\\Desktop\\sm.properties");                                                  
                                                  
            Human ivanov = new Human("Ivanov", new Asset("ho", 999_999.99), new Asset("car", 2999.99));                                                  
            ivanov.save(outputStream);                                                  
            outputStream.flush();                                                  
                                                  
            Human somePerson = new Human();
            somePerson.load(inputStream);                                                  
            inputStream.close();                                                  
            //check here that ivanov equals to somePerson - ��������� ���, ��� ivanov � somePerson �����
            
            System.out.println(ivanov.equals(somePerson));
            somePerson.assets.forEach(a -> System.out.println(a.getName() + " " + a.getPrice()));
                                                  
        } catch (IOException e) {                                                  
            e.printStackTrace();                                                  
            System.out.println("Oops, something wrong with my file");                                                  
        } catch (Exception e) {                                                  
            e.printStackTrace();                                                  
            System.out.println("Oops, something wrong with save/load method");                                                  
        }                                                  
    }                                                  
                                                  
    public static class Human {                                                  
        public String name;                                                  
        public List<Asset> assets = new ArrayList<>();                                                  
                                                  
        public Human() {                                                  
        }                                                  
                                                  
        public Human(String name, Asset... assets) {                                                  
            this.name = name;                                                  
            if (assets != null) {                                                  
                this.assets.addAll(Arrays.asList(assets));                                                  
            }                                                  
        }                                                  
                                                  
        @Override                                                  
        public boolean equals(Object o) {                                                  
            if (this == o) return true;                                                  
            if (o == null || getClass() != o.getClass()) return false;                                                  
                                                  
            Human human = (Human) o;                                                  
                                                  
            if (name != null ? !name.equals(human.name) : human.name != null) return false;                                                  
            return assets != null ? assets.equals(human.assets) : human.assets == null;                                                  
        }                                                  
                                                  
        @Override                                                  
        public int hashCode() {                                                  
            int result = name != null ? name.hashCode() : 0;                                                  
            result = 31 * result + (assets != null ? assets.hashCode() : 0);                                                  
            return result;                                                  
        }                                                  
                                                  
        public void save(OutputStream outputStream) throws Exception {                                                  
        	try(PrintStream printStream = new PrintStream(outputStream)){
        		if(name != null) 
	        		printStream.println(name);
        		
            	if(!assets.isEmpty()) {
	        		assets.forEach(a -> {
	        			printStream.println(a.getName());
	        			printStream.println(a.getPrice());
	        			printStream.flush();
	        		});
            	}
        	}
        }                                                  
                                                  
        public void load(InputStream inputStream) throws Exception {
        	try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream))){
            	String name;
            	if((name = buffReader.readLine()) != null)
            		this.name = name;

	            	while(buffReader.ready()) 
	            		assets.add(new Asset(buffReader.readLine(), Double.parseDouble(buffReader.readLine())));
            }
        }                                                  
    }                                                  
}