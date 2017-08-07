package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

/**
 * sets the last modified time in milliseconds
 * @author ShaQuan
 *
 */
public class SettingTimeStamps {
	public static void main(String[] args) {
		Path file = BasicFileAttributesTest.file;
		
		/**
		 * Setting Time Stamps
		 */
		long currentTime = System.currentTimeMillis();
		FileTime ft = FileTime.fromMillis(currentTime);
		try {
			Files.setLastModifiedTime(file, ft);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
