package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * 用户定义的文件属性
 * If the file attributes supported by your file system 
 * implementation aren't sufficient for your needs, you 
 * can use the UserDefinedAttributeView to create and 
 * track your own file attributes.
 * 如果您的文件系统实现支持的文件属性不足以满足您的需要，可以
 * 使用UserDefinedAttributeView创建和跟踪您自己的文件属性。
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
