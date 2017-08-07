package oracle.javase.tutorial.io.access;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import oracle.javase.tutorial.io.metadata.LocalPath;
import static java.nio.file.StandardOpenOption.*;
public class RandomAccessFiles {
	public static void main(String[] args) {
		String s = "I was here!\n";
		byte[] data = s.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);//�� byte �����װ���������С�
		ByteBuffer copy = ByteBuffer.allocate(12);
		
		Path path = Paths.get(LocalPath.DESPTOP_A.getPath() + "a.txt");
		
		try(FileChannel fc = FileChannel.open(path, READ, WRITE)) {
			//Read the first 12
			//bytes of the file
			int nread;
			do{
				nread = fc.read(copy);
			}while(nread != -1 && copy.hasRemaining());//��֪�ڵ�ǰλ�ú�����֮���Ƿ���Ԫ��
			System.out.println(fc.toString().length());
			//Write "I was here!" at the beginning of the file.
			fc.position(0);
			while(out.hasRemaining()) fc.write(out);
			/*
			 * ���ƴ˻���������λ������Ϊ 0 ��������ǡ�
			 * ��һϵ��ͨ��д����ȡ ����֮ǰ���ô˷������ٶ��Ѿ��ʵ����������ƣ������磺
			 *  out.write(buf);    // Write remaining data
			 *  buf.rewind();      // Rewind buffer
			 *  buf.get(array);    // Copy data into array
			 */
			out.rewind();
			// Move to the end of the file.  Copy the first 12 bytes to
		    // the end of the file.  Then write "I was here!" again.
			long length = fc.size();
			fc.position(length - 1);
			copy.flip();
			while(copy.hasRemaining()) fc.write(copy);
			while(out.hasRemaining()) fc.write(out);
		} catch (Exception e) {
			System.out.println("IOException:" + e);
		}
	}
}
