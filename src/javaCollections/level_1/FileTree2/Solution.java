package javaCollections.level_1.FileTree2;

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
	
	@author Alex Mordyasov                                          
*/                                                  
public class Solution {  
	/**
	 * 
	 * @param root - (полный путь к папке)
	 * @return list - (коллекция после добавления файлов)
	 * @throws IOException
	 */
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
    	List<String> list = getFileTree("Absolute Path Directory");
    	list.forEach(System.out::println);
    }                                                  
}