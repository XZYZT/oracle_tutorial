package oracle.javase.tutorial.io.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * NOTE: Example code to list/set/get/delete the user-defined attributes 
 * of a file.
 * 
 * In Linux, you might have to enable extended attributes for user-defined 
 * attributes to work. If you receive an UnsupportedOperationException when 
 * trying to access the user-defined attribute view, you need to remount 
 * the file system. The following command remounts the root partition with 
 * extended attributes for the ext3 file system. If this command does not 
 * work for your flavor of Linux, consult the documentation.
 * 
 * $ sudo mount -o remount,user_xattr /
 * 
 * If you want to make the change permanent, add an entry to /etc/fstab.
 * 
 * get, set, and delete a user-defined attribute.
 * @author ShaQuan
 *
 */
public class Xdd {
	static void usage(){
		System.out.println("Usage: java Xdd <file>");
        System.out.println("       java Xdd -set <name>=<value> <file>");
        System.out.println("       java Xdd -get <name> <file>");
        System.out.println("       java Xdd -del <name> <file>");
        System.exit(-1);
	}
	
	public static void main(String[] args) throws IOException {
		//one or three parameters
		if(args.length != 1 && args.length !=3) usage();
		
		Path file = (args.length == 1) ? Paths.get(args[0]) : Paths.get(args[2]);
		
		//check that user defined attributes are supported by the file store
		FileStore store = Files.getFileStore(file);
		if(!store.supportsFileAttributeView(UserDefinedFileAttributeView.class)){
			System.err.format("UserDefineFileAttributeView not supported on %s%n", store);
			System.exit(-1);
		}
		UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
		//list user defined attributes
		if(args.length == 1){
			System.out.println("    Size  Name");
            System.out.println("--------  --------------------------------------");
            for (String name: view.list()) {
                System.out.format("%8d  %s\n", view.size(name), name);
            }
            return;
		}
		//add/replace a file's user defined attribute
		if(args[0].equals("-set")){
			String[] s = args[1].split("=");
			if(s.length != 2){
				usage();
			}
			String name = s[0];
			String value = s[1];
			view.write(name, Charset.defaultCharset().encode(value));
			return;
		}
		//print out the value of a file's user defined attribute
		if(args[0].equals("-get")){
			String name = args[1];
			int size = view.size(name);
			ByteBuffer buf = ByteBuffer.allocate(size);
			view.read(name, buf);
			buf.flip();
			System.out.println(Charset.defaultCharset().decode(buf));
			return;
		}
		//delete a file's user defined attribute
		if(args[0].equals("-del")){
			view.delete(args[1]);
			return;
		}
		//option not recognized
		usage();
	}
}