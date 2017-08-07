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
		 * POSIX是UNIX的便携式操作系统接口的首字母缩略词，
		 * 是一组旨在确保不同口味UNIX之间的互操作性的IEEE和ISO标准。 
		 * 如果程序符合这些POSIX标准，则应该轻松地将其移植到其他与
		 * POSIX兼容的操作系统上。
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
