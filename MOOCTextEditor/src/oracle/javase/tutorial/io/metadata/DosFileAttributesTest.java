package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributes;
/**
 * DOS file attributes are also supported on file systems 
 * other than DOS, such as Samba.
 * @author ShaQuan
 *
 */
public class DosFileAttributesTest {
	public static void main(String[] args) throws IOException {
		Path file = LocalPath.DESPTOP_A.path();
		/**
		 * DOS File Attributes
		 */
		try {
		    DosFileAttributes dosAttr = Files.readAttributes(file, DosFileAttributes.class);
		    System.out.println("isReadOnly is " + dosAttr.isReadOnly());
		    System.out.println("isHidden is " + dosAttr.isHidden());
		    System.out.println("isArchive is " + dosAttr.isArchive());
		    System.out.println("isSystem is " + dosAttr.isSystem());
		} catch (UnsupportedOperationException x) {
		    System.err.println("DOS file" + " attributes not supported:" + x);
		}
		
		Files.setAttribute(file, "dos:hidden", true);
	}
}
