package oracle.javase.tutorial.io.rwc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class CommonlyUsedSmallFiles {
	public static void main(String[] args) throws IOException {
		Path file = LocalPath.DESPTOP_B_FILE.path();
		byte[] buf = {'a','b'};
		Files.write(file, buf);
	}
}
