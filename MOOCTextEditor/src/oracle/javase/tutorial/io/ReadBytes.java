package oracle.javase.tutorial.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadBytes {
	public static void main(String[] args) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File("WY-YYS-DATA.pcap"));
//			int c;
//			while((c = in.read()) != -1){
//				System.out.println(Integer.toBinaryString(c) + "  " + (char)c + "  " + (byte)c);
//			}
			byte[] b = new byte[4];
			while(in.read(b) != -1){
				System.out.println(bytesToHexString(b));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	}   
}
