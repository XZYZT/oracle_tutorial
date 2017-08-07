package oracle.javase.tutorial.io.link;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class HardLink {
	public static void main(String[] args) {
		Path newHardLink = Paths.get(LocalPath.DESPTOP_A.getPath() + "../hardLink.txt");
		Path existingFile = Paths.get(LocalPath.DESPTOP_B.getPath() + "HARD.txt");
		createHardLink(newHardLink, existingFile);
		SymblicLink.deleteSymbolicLink(newHardLink);
	}

	public static void createHardLink(Path newLink, Path existingFile){
		try {
			Files.createLink(newLink, existingFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			//some file system do not support adding an existing file to a directory
			e.printStackTrace();
		}
	}
}
