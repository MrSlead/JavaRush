package javaCollections.level_1.FileTreeAdvanced;

import java.io.IOException;                                                  
import java.nio.file.Files;                                                  
import java.nio.file.Path;                                                  
import java.nio.file.Paths;                                                  
import java.util.List;                                                  
                                                  
/*                                               
 * Продвинутый поиск файлов. 
 * Указываем критерии поиска файла, если один критерий не выполняется - файл не добавляется в коллекцию.                                       
 */                                                  
public class Solution {                                                  
                                                  
    public static void main(String[] args) throws IOException {                                                  
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();                                                  
                                                  
        searchFileVisitor.setPartOfName("amigo");                                                  
        searchFileVisitor.setPartOfContent("programmer");                                                  
        searchFileVisitor.setMinSize(0);                                                  
        searchFileVisitor.setMaxSize(10000);                                                  
                                                  
        Files.walkFileTree(Paths.get("D:\\Разное\\"), searchFileVisitor);                                                  
                                                  
        List<Path> foundFiles = searchFileVisitor.getFoundFiles();                                                  
        for (Path file : foundFiles) {                                                  
            System.out.println(file);                                                  
        }                                                  
    }                                                  
                                                  
}