package oracle.javase.tutorial.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;
import oracle.javase.tutorial.io.metadata.LocalPath;

public class MoveFile {
	public static void main(String[] args) throws IOException {
		Path file = Paths.get(LocalPath.DESPTOP_C.getPath() + "createTemporaryFile.txt");
		Path dir = Paths.get(LocalPath.DESPTOP_D.getPath() + "createTemporaryFile.txt");
//		UserPrincipal principal = dir.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("shaquan");
//		Files.setOwner(dir, principal);
		Files.move(file, dir, REPLACE_EXISTING);
	}
}
