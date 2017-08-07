package oracle.javase.tutorial.io.dir;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CreAndReadDir {
	public static void main(String[] args) {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
		    System.err.println(name);
		}
	}
}
