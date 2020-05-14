package javaCollections.level_1.FileTreeAdvanced;

import java.io.IOException;                                                  
import java.nio.file.FileVisitResult;                                                  
import java.nio.file.Files;                                                  
import java.nio.file.Path;                                                  
import java.nio.file.SimpleFileVisitor;                                                  
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;  
import java.util.List;
                                                  
public class SearchFileVisitor extends SimpleFileVisitor<Path> {                                                  
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();
    
    @Override                                                  
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {                                                  
        byte[] content = Files.readAllBytes(file); // размер файла: content.length                                                  
        String contentText = new String(content, "UTF-8");
        
        boolean containsName = true;
        if(partOfName != null) {
        	if(!file.toFile().getName().contains(partOfName)) {
        		containsName = false;
        	}
        }
        
        boolean containsContent = true;
        if(partOfContent != null) {
        	if(!contentText.contains(partOfContent)) {
        		containsContent = false;
        	}
        }
        
        boolean moreMinSize = true;
        if(minSize != -1) {
        	if(!(minSize <= content.length)) {
        		moreMinSize = false;
        	}
        }
        
        boolean lessMaxSize = true;
        if(maxSize != -1) {
        	if(!(maxSize >= content.length)) {
        		lessMaxSize = false;
        	}
        }
        
        if(containsName && containsContent && moreMinSize && lessMaxSize) {
        	foundFiles.add(file);
        }
        
        return super.visitFile(file, attrs);                                                  
    }
    

	public void setPartOfName(String partOfName) {
		this.partOfName = partOfName;
	}

	public void setPartOfContent(String partOfContent) {
		this.partOfContent = partOfContent;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public List<Path> getFoundFiles(){
		return foundFiles;
	}
    
    
}