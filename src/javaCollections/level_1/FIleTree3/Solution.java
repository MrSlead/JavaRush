package javaCollections.level_1.FIleTree3;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;      

/**
 * В классе Solution переопредели логику двух методов:
- visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
- visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE
 * @author Кокон2
 *
 */                                        
/*                                                   
Поиск скрытых файлов                                                  
*/                                                  
public class Solution extends SimpleFileVisitor<Path> {  
    private List<String> archived = new ArrayList<>();                                                  
    private List<String> failed = new ArrayList<>();  
    
    public static void main(String[] args) throws IOException {                                                  
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);                                                  
        final Solution solution = new Solution();                                                  
        Files.walkFileTree(Paths.get("D:\\Фрапс\\Разное\\Миры терраии"), options, 20, solution);                                                  
                                                  
        List<String> result = solution.getArchived();                                                  
        System.out.println("All archived files:");                                                  
        for (String path : result) {                                                  
            System.out.println("\t" + path);                                                  
        }                                                  
                                                  
        List<String> failed = solution.getFailed();                                                  
        System.out.println("All failed files:");                                                  
        for (String path : failed) {                                                  
            System.out.println("\t" + path);                                                  
        }                                                  
    }                                                  
                                                  
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    	if(file.toAbsolutePath().toString().endsWith("zip") || file.toAbsolutePath().toString().endsWith("rar")) {
    		archived.add(file.toAbsolutePath().toString());
    	}
    	
		return super.visitFile(file, attrs);
    	
    }
    
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
    	failed.add(file.toAbsolutePath().toString());
		return FileVisitResult.SKIP_SUBTREE;
    	
    }
                                                  
    public List<String> getArchived() {                                                  
        return archived;                                                  
    }                                                  
                                                  
    public List<String> getFailed() {                                                  
        return failed;                                                  
    }                                                  
}