package javaCollections.level_1.GeneralInformationAboutDirectory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorSearch extends SimpleFileVisitor<Path> {
	private int countDirectory = -1;
	private int countFile;
	private long sizeDirectory;
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(file.toFile().isFile()){
			countFile++;
			sizeDirectory = sizeDirectory + Files.size(file);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
		if(Files.isDirectory(file)) {
			countDirectory++;
		}
		return FileVisitResult.CONTINUE;
	}
	
	public int getCountDirectory() {
		return countDirectory;
	}

	public int getCountFile() {
		return countFile;
	}

	public long getSizeDirectory() {
		return sizeDirectory;
	}
}
