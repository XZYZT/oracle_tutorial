package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * http://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html
 * 
 * A file system's metadata is typically referred to as its file attributes. 
 * The Files class includes methods that can be used to obtain a single 
 * attribute of a file, or to set an attribute.
 * �ļ�ϵͳ��Ԫ����ͨ����Ϊ���ļ����ԡ� Files����������ڻ�ȡ�ļ��ĵ������Ի��������Եķ�����
 * @author ShaQuan
 *
 */
public class BasicFileAttributesTest {
	public static Path file = Paths.get("C:/Users/ShaQuan/Desktop/a");
	public static void main(String[] args) throws IOException {
		/**
		 * Basic File Attributes
		 */
		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
		
		System.out.println("isDirectory: " + attr.isDirectory());
		System.out.println("isOther: " + attr.isOther());
		System.out.println("isRegularFile: " + attr.isRegularFile());
		System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
		System.out.println("size: " + attr.size());
		
		
	}
}
