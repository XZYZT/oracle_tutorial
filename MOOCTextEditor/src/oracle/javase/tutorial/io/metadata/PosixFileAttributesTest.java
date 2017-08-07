package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest {
	public static void main(String[] args) throws IOException {
		/**
		 * POSIX File Permissions
		 * POSIX��UNIX�ı�Яʽ����ϵͳ�ӿڵ�����ĸ���Դʣ�
		 * ��һ��ּ��ȷ����ͬ��ζUNIX֮��Ļ������Ե�IEEE��ISO��׼�� 
		 * ������������ЩPOSIX��׼����Ӧ�����ɵؽ�����ֲ��������
		 * POSIX���ݵĲ���ϵͳ�ϡ�
		 */
		Path file = LocalPath.DESPTOP_A.path();
		
		PosixFileAttributes posixAttr = Files.readAttributes(file, PosixFileAttributes.class);
		System.out.format("%s %s %s%n",
				posixAttr.owner().getName(),
				posixAttr.group().getName(),
			    PosixFilePermissions.toString(posixAttr.permissions()));
		
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-------");
		FileAttribute<Set<PosixFilePermission>> posixAttrSs = PosixFilePermissions.asFileAttribute(perms);
		Files.setPosixFilePermissions(file, perms);
	}
}
