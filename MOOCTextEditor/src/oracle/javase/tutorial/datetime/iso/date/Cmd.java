package oracle.javase.tutorial.datetime.iso.date;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Cmd {
	public static void main(String[] args) throws IOException {
		String filepath = "C:/Users/ShaQuan/Desktop/shaquan.bat";
		openFile(filepath) ;
	}
	
	public static void openFile(String filepath) throws IOException {
		Desktop.getDesktop().open(new File(filepath));
	}
}
