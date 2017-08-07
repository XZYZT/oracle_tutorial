package oracle.javase.tutorial.io.other;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DeterminingMIME {
	static Path filename = Paths.get("C:/Users/ShaQuan/Desktop/WY-YYS-DATA.pcap");
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(~0));
		
		
		try {
		    String type = Files.probeContentType(filename);
		    if (type == null) {
		        System.err.format("'%s' has an unknown filetype.%n", filename);
		    } else {
		    	System.err.format("'%s' MIME type is %s ", filename, type);
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
}
