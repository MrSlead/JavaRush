import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;                                                  
                                                  
/**                                                   
	Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
	Используй очередь, рекурсию не используй.
	Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
	Путь должен быть абсолютный.                                                 
*/                                                  
public class Solution {                                                  
    public static List<String> getFileTree(String root) throws IOException {                                                  
        List<String> list = new ArrayList<String>();
        Stack<File> stack = new Stack<>();
        
        File rootDirectory = new File(root);
        stack.add(rootDirectory);
        
        while(!stack.isEmpty()) {
        	File child = stack.pop();
        	if(child.isDirectory()) {
	        	for(File f : child.listFiles()) {
	        		stack.add(f);
	        	}
        	}
        	else {
        		list.add(child.getAbsolutePath());
        	}
        } 
        
        return list;
    }                                                  
                                                  
    public static void main(String[] args) throws IOException {                                                  
    	List<String> list = getFileTree("C:\\Users\\Кокон2\\workspace\\JavaRush\\JavaRush\\src");
    	list.forEach(System.out::println);
    }                                                  
}