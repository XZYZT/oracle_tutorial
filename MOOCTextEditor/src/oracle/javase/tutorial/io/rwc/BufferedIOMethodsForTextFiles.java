package oracle.javase.tutorial.io.rwc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class BufferedIOMethodsForTextFiles {
	public static void main(String[] args) {
		Path file = LocalPath.DESPTOP_B_FILE.path();
		Charset charset = Charset.forName("US-ASCII");
		/**
		 * Reading a File by Using Buffered Stream I/O
		 */
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		/**
		 * Writing a File by Using Buffered Stream I/O
		 * create a file encoded in "US-ASCII" 
		 */
		String s = "abcde";
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(s, 0, s.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
}
