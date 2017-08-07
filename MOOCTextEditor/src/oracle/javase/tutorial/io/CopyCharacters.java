package oracle.javase.tutorial.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Using character streams
 * @author ShaQuan
 *
 */
public class CopyCharacters {
	public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("oracle_tutorial/io/xanadu.txt");
            outputStream = new FileWriter("oracle_tutorial/io/characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
