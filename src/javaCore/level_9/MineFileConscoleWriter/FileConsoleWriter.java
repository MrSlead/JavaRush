package javaCore.level_9.MineFileConscoleWriter;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter + write text in console.
 */

public class FileConsoleWriter {
	private FileWriter fileWriter;
	
	public FileConsoleWriter(File file) throws IOException {
		fileWriter = new FileWriter(file);
	}
	
	
	public FileConsoleWriter(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
	}
	
	
	public FileConsoleWriter(FileDescriptor fd) {
		fileWriter = new FileWriter(fd);
	}
	
	
	public FileConsoleWriter(File file, boolean append) throws IOException {
		fileWriter = new FileWriter(file, append);
	}
	
	
	public FileConsoleWriter(String fileName, boolean append) throws IOException {
		fileWriter = new FileWriter(fileName, append);
	}
	
	
	public static void main(String[] args) {
	}
	
	
	public void write(int c) throws IOException {
		fileWriter.write(c);
		
		System.out.print((char) c);
	}
	
	
	public void write(String str) throws IOException {
		fileWriter.write(str);
		
		System.out.print(str);
	}
	
	
	public void write(String str, int off, int len) throws IOException {
		if(off + len < str.length()) {
			fileWriter.write(str, off, len);
			
			System.out.print(str.substring(off, off + len));
		}
	}
	
	
	public void write(char[] cbuf) throws IOException {
		fileWriter.write(cbuf);
		
		System.out.print(cbuf);
	}
	
	
	public void write(char[] cbuf, int off, int len) throws IOException {
		if(off + len < cbuf.length) {
			fileWriter.write(cbuf, off, len);
		
			System.out.print(String.valueOf(cbuf).substring(off, off + len));
		}
	}
	
	
	public void close() throws IOException {
		fileWriter.close();
	}
}
