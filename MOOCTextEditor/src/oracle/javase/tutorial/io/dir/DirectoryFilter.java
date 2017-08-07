package oracle.javase.tutorial.io.dir;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * 
 * @author ShaQuan
 *
 */
public class DirectoryFilter {
	public static void main(String[] args){
		String path = System.getProperty("sun.boot.library.path");
		Path dir = Paths.get(path);
		System.out.println(path);
		DirectoryStream.Filter<Path> filter = directoryFilter();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)) {
			for(Path entry : stream){
				System.out.println(entry.getFileName());
			}
		} catch (IOException e) {
			System.out.printf("IOException:%s\n", e);
		}
	}

	public static DirectoryStream.Filter<Path> directoryFilter(){
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path entry) throws IOException {
				return (Files.isDirectory(entry));
			}
		};
		return filter;
	}
}
