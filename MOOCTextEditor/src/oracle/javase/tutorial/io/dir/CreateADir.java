package oracle.javase.tutorial.io.dir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class CreateADir {
	public static void main(String[] args) throws IOException {
		String path = LocalPath.DESPTOP_A.getPath() + java.io.File.separator + "createDirs/dir1/dir2";
		Path dir = Paths.get(path);
		Files.createDirectories(dir);
		/**
		 * creates a new directory on a POSIX file system that has specific permissions
		 */
//		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
//		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
//		Files.createDirectory(dir, attr);
		/**
		 * To create a directory several levels deep when 
		 * one or more of the parent directories might 
		 * not yet exist
		 * 创建多个级别深度的目录：
		 * 
		 * Files.createDirectories(Paths.get("foo/bar/test"));
		 */
		
	}
}
