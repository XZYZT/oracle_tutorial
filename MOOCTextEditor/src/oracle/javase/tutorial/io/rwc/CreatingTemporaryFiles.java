package oracle.javase.tutorial.io.rwc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * You can create a temporary file using one of the following 
 * createTempFile methods:
 * createTempFile(Path, String, String, FileAttribute<?>)
 * createTempFile(String, String, FileAttribute<?>)
 * 
 * The specific format of the temporary file name is platform specific.
 * @author ShaQuan
 *
 */
public class CreatingTemporaryFiles {
	public static void main(String[] args) {
		try {
			Path tempFile = Files.createTempFile(null, ".myapp");
		    System.out.format("The temporary file has been created: %s%n", tempFile);
		} catch (IOException e) {
			
		}
	}
}
