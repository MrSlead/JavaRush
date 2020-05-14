package javaCollections.level_1.FileTree;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * <p> 1. The input of the main() method serves two parameters.
 * First-path - path to the directory, second-resultFileAbsolutePath-name (full path) an existing file that will contain the result.</p>
 * <p> 2. Rename resultFileAbsolutePath to allFilesContent.txt
 * (use the FileUtils.renameFile () method, and, if necessary, FileUtils.isExist () method).</p>
 * <p> 3. for each file in the path directory and all its nested subdirectories, do the following:
 * If the file has a maximum length of 50 bytes, then for all such files:</p>
 * <p> 3.1. Sort them by file name in ascending order, the path is not taken into account when sorting.</p>
 * <p> 3.2. In allFilesContent.txt consistently record the contents of all files in section 3.1. After each body of the file write "\n".
 * All files have the txt extension.
 * Use "/"as the path separator.
 * To create files, use the File constructor (String pathname).</p>
 * 
 * @version 1.0.0
 * 
 * @author Alex Mordyasov
 *
 */
public class Solution {
	private ArrayList<File> files = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        
        String newNameFile = "allFilesContent.txt";
        System.out.println(path.getAbsolutePath());
        String newResultFileAbsolutePath = path.getAbsolutePath() + '\\' + newNameFile;
        File file = new File(newResultFileAbsolutePath);
        
        if(FileUtils.isExist(resultFileAbsolutePath)) {
        	FileUtils.renameFile
        		(resultFileAbsolutePath, file);
        }
        
        
        Solution solution = new Solution();
        solution.addFilesDirectory(path, newNameFile, solution.files);
        
        Collections.sort(solution.getFiles(), (a, b) -> a.getName().compareTo(b.getName()));
        
        solution.getFiles().forEach(f -> System.out.println(f.getName()));
        
        solution.writeInFile(file, solution.getFiles());
       
    }
    
    /**
     * 
     * @param file - start directory (args[0])
     * @param newNameFile - name file after rename
     * @param list
     */
    public void addFilesDirectory(File file, String newNameFile, List<File> list) {
    	for(File f : file.listFiles()) {
        	if(f.isDirectory()) {
        		addFilesDirectory(new File(f.getAbsolutePath()), newNameFile, list);
        	}
    		if(f.length() <= 50 && !f.isDirectory() && !f.getName().equals(newNameFile)) {
    			list.add(f);
    		}
    	}
    }
    
    /**
     * 
     * @param f - (args[1])
     * @param list
     * @throws IOException
     */
    public void writeInFile(File f, List<File> list) throws IOException {
    	try(FileWriter fileWriter = new FileWriter(f.getAbsolutePath())){
    		for(File file : list) {
    			try(FileReader fileReader = new FileReader(file)){
    				while(fileReader.ready()) {
    					fileWriter.write(fileReader.read());
    				}
    			}
    			fileWriter.write('\r');
    			fileWriter.write('\n');
    		}
    	}
    }
    
    public List<File> getFiles(){
    	return files;
    }
}