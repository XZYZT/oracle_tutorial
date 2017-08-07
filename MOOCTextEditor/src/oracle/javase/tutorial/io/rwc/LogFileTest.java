package oracle.javase.tutorial.io.rwc;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;
/**
 * The following example opens a log file. 
 * If the file does not exist, it is created.
 * If the file exists, it is opened for appending.
 * @author ShaQuan
 *
 */
public class LogFileTest {
	public static void main(String[] args) {
		String s = "Hello World!\n";
		byte[] data = s.getBytes();
		Path p = Paths.get("./logfile.txt");
		
		try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND))) {
			out.write(data, 0, data.length);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
