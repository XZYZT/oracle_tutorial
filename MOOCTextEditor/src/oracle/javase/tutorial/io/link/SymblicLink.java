package oracle.javase.tutorial.io.link;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class SymblicLink {
	public static void main(String[] args) {
		Path newLink = Paths.get(LocalPath.DESPTOP_A.getPath() + "/SymblicLink");
		Path target = LocalPath.DESPTOP_B.path();
		createSymbolicLink(newLink, target);
		findLink(newLink);
//		deleteSymbolicLink(newLink);
	}
	
	public static void createSymbolicLink(Path newLink, Path target){
		try {
			Files.createSymbolicLink(newLink, target);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			// Some file systems do not support symbolic links.
			e.printStackTrace();
		}
	}
	/*
	 * For more information, see Managing Metadata.
	 * http://docs.oracle.com/javase/tutorial/essential/io/fileAttr.html
	 */
	public static void deleteSymbolicLink(Path file){
		boolean isExist = Files.exists(file);
		boolean isSymbolicLink = Files.isSymbolicLink(file);
		if(!isExist){
			System.out.println("File not exist " + file);
			return;
		}
		if(isSymbolicLink){
			try {
				Files.delete(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Not a symbolic: " + file);
		}
	}
	/*
	 * If the Path is not a symbolic link, this method throws a NotLinkException.
	 */
	public static void findLink(Path link){
		try {
		    System.out.format("Target of link '%s' is '%s'%n", link, Files.readSymbolicLink(link));
		} catch (IOException x) {
			x.printStackTrace();
		}
	}
}
