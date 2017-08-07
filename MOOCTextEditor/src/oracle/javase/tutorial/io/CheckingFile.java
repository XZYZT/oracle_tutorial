package oracle.javase.tutorial.io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingFile {
	public static void main(String[] args) throws IOException {
		Path file = Paths.get("C:/Users/ShaQuan/Desktop/b");
		boolean isRegularExecutableFile = Files.isRegularFile(file) & 
				Files.isReadable(file) & Files.isExecutable(file);
		System.out.println("isWritable:" + Files.isReadable(file));
		System.out.println("isRegularFile:" + Files.isRegularFile(file));
		System.out.println("isExecutable:" + Files.isExecutable(file));
		System.out.println("isWritable:" + Files.isWritable(file));
		System.out.println("isDirectory:" + Files.isDirectory(file));
		System.out.println("lastModifiedTime:" + Files.getLastModifiedTime(file));
		System.out.println("owner:" + Files.getOwner(file));
		Path file2 = Paths.get("C:/Users/ShaQuan/Desktop/d");
		try {
			System.out.println("isSameFile:" + Files.isSameFile(file, file2));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			Files.delete(file);
//		} catch (NoSuchFileException e) {
//			System.err.format("%s:no such file or directory%n", e.getFile());
//		} catch (DirectoryNotEmptyException e){
//			System.err.format("%s not empty %n", e.getFile());
//		} catch (IOException e) {
//		    System.out.println(e);
//		}
	}
}
