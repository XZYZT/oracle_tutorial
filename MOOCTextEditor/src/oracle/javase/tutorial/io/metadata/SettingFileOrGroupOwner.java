package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
/**
 * 设置文件所有者
 * @author ShaQuan
 *
 */
public class SettingFileOrGroupOwner {
	
	public static void main(String[] args) throws IOException {
		/**
		 *  set the file owner by using the setOwner method
		 */
		Path file = LocalPath.DESPTOP_B.path();
		UserPrincipal owner = file.getFileSystem().getUserPrincipalLookupService()
		        .lookupPrincipalByName("shaquan");
		Files.setOwner(file, owner);
		System.out.println(owner.toString());
		
		GroupPrincipal group =
			    file.getFileSystem().getUserPrincipalLookupService()
			        .lookupPrincipalByGroupName("green");
		Files.getFileAttributeView(file, PosixFileAttributeView.class)
		     .setGroup(group);
	}
}
