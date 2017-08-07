package course.regular.demo;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Port {
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 6316;
		try {
			Socket socket = new Socket(ip, port);
			socket.setSoTimeout(5539900);
			java.io.OutputStream out = socket.getOutputStream();
		
			byte[] data = "hello world".getBytes();
			out.write(data);
			out.flush();
			byte[] buffer = new byte[1024];
			int len = -1;
			FileOutputStream fout = new java.io.FileOutputStream("d:/response.txt");
			ByteArrayOutputStream bout = new java.io.ByteArrayOutputStream();
			InputStream in = socket.getInputStream();
			while ((len = in.read(buffer, 0, buffer.length)) > 0) {
			bout.write(buffer, 0, len);
		}
			in.close();
			bout.flush();
			bout.close();
		
			byte[] rdata = bout.toByteArray();
			System.out.println(new String(rdata));
		
			fout.write(rdata);
			fout.flush();
			fout.close();
			socket.close(); 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
