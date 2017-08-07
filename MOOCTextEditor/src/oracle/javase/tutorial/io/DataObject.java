package oracle.javase.tutorial.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class DataObject {
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("IO", "E:\\MyDir");
		System.out.println(p.getProperty("IO"));
		p.remove("IO");
		System.out.println(p.getProperty("IO"));
	}
}
