package javaCollections.level_1.DowloadFileFromInternet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;                                                  
import java.nio.file.Path;                                                  
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;                                                  
                                                  
/*                                                   
 *  Скачивает файл с сайта и перемещает в указанную директорию.                                              
 */                                                  
public class Solution {                                                  
                                                  
    public static void main(String[] args) throws IOException {                                                  
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:\\Разное"));                                                  
                                                  
        for (String line : Files.readAllLines(passwords)) {                                                  
            System.out.println(line);                                                  
        }                                                  
    }                                                  
                                                  
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {                                                  
        URL url = new URL(urlString); 

        Path tempDirectory = Files.createTempDirectory(downloadDirectory.toFile().getName());
       
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        
        String nameFile = urlString.substring(urlString.lastIndexOf('/')+1, urlString.length());
        Path downloadFile = Paths.get(tempDirectory.toFile().getAbsolutePath() + "//" + nameFile);
        FileOutputStream fileOutputStream = new FileOutputStream(downloadFile.toFile());
        FileChannel fileChannel = fileOutputStream.getChannel();
       
        fileOutputStream.getChannel()
        .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        
        Files.copy(downloadFile, Paths.get(downloadDirectory.toAbsolutePath().toString() + "\\" + downloadFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        
        fileOutputStream.close();
        fileChannel.close();
        readableByteChannel.close();
        
    	/* URL url = new URL(urlString);
         ReadableByteChannel rbc = Channels.newChannel(url.openStream());
         Path s = Paths.get(downloadDirectory.toAbsolutePath().toString() + "//set.xml");
         
         FileOutputStream fos = new FileOutputStream(s.toFile());
         fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
         fos.close();
         rbc.close();*/
        
    	
        return downloadFile;
    }                                                  
}