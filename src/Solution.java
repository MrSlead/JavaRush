import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
	public static void main(String [] args) throws IOException {
		Path file = Paths.get("C:\\Users\\Кокон2\\Desktop\\test.txt");
		
		Path folder = Files.createDirectory(Paths.get("ss"));
		Path zip = Paths.get("C:\\Users\\Кокон2\\Desktop\\ДЗ.zip");
		ZipOutputStream zipOS = new ZipOutputStream(new FileOutputStream(zip.toFile()));
		
		//Path directory = Paths.get(file.getParent() + "\\new");
		//Files.copy(file, Paths.get(directory.toString() + "\\" + file.getFileName()));
		System.out.println(folder.toAbsolutePath().toString());
		//zipOS.putNextEntry(new ZipEntry(folder.toString() + "\\"));
		zipOS.putNextEntry(new ZipEntry("doc.txt"));
		Files.copy(file, zipOS);
		
		//zipOS.close();
		
		
	}
}

	
