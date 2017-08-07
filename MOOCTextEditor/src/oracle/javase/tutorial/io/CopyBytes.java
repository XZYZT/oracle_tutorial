package oracle.javase.tutorial.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Using byte stream
 * @author ShaQuan
 *
 */
public class CopyBytes {
	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
            in = new FileInputStream("oracle_tutorial/io/xanadu.txt");
            out = new FileOutputStream("oracle_tutorial/io/byteoutput.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
	}
}
