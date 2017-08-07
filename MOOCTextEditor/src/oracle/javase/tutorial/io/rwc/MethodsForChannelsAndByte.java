package oracle.javase.tutorial.io.rwc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Reading and Writing Files by Using Channel I/O
 * @author ShaQuan
 *
 */
public class MethodsForChannelsAndByte {
	public static void main(String[] args) {
		Path file = Paths.get("./logfile.txt");
		try(SeekableByteChannel sbc = Files.newByteChannel(file)) {
			ByteBuffer buf = ByteBuffer.allocate(10);
			String encoding = System.getProperty("file.encoding");
			while(sbc.read(buf) > 0){
				buf.rewind();
				System.out.println(Charset.forName(encoding).decode(buf));
				buf.flip();
			}
		} catch (IOException e) {
			System.out.println("caught io exception:" + e);
		}
	}
}
