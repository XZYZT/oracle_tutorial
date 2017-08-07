package oracle.javase.tutorial.io.rwc;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import oracle.javase.tutorial.io.metadata.LocalPath;
/**
 * creates a file with default attributes:
 */
public class CreatingFiles {
	public static void main(String[] args) {
		Path file = Paths.get(LocalPath.DESPTOP_A.getPath() + "/createDefaultFile.txt");
		//create the empty file with default permissions, etc.
		try {
			Files.createFile(file);
			System.out.format("The file has been created %s/n", file);
		} catch (FileAlreadyExistsException e) {
			System.err.format("file named %s already exists%n", file);
		} catch (IOException e) {
			// Some other sort of failure, such as permissions.
		    System.err.format("createFile error: %s%n", e);
		}
	}
}
