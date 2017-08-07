package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * �û�������ļ�����
 * If the file attributes supported by your file system 
 * implementation aren't sufficient for your needs, you 
 * can use the UserDefinedAttributeView to create and 
 * track your own file attributes.
 * ��������ļ�ϵͳʵ��֧�ֵ��ļ����Բ���������������Ҫ������
 * ʹ��UserDefinedAttributeView�����͸������Լ����ļ����ԡ�
 * @author ShaQuan
 *
 */
public class UserDefinedFileAttributes {
	public static void main(String[] args) throws IOException {
		Path file = BasicFileAttributesTest.file;
		UserDefinedFileAttributeView view = Files
		    .getFileAttributeView(file, UserDefinedFileAttributeView.class);
		
		String name = "user.mimetype";
		view.write(name, Charset.defaultCharset().encode("text/html"));
		ByteBuffer buf = ByteBuffer.allocate(view.size(name));
		view.read(name, buf);
		buf.flip();
		String value = Charset.defaultCharset().decode(buf).toString();
		System.out.println(value);
		
	}
}
