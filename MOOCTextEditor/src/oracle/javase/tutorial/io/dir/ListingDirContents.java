package oracle.javase.tutorial.io.dir;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDirContents {
	public static void main(String[] args) {
		Path dir = Paths.get(System.getProperty("java.io.tmpdir"));
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)) {
			for(Path file : dirStream){
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException e) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(e);
		}
	}
}
