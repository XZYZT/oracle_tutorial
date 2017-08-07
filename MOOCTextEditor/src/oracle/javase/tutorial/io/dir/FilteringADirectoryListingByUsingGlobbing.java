package oracle.javase.tutorial.io.dir;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilteringADirectoryListingByUsingGlobbing {
	public static void main(String[] args) {
		String path = System.getProperty("sun.boot.library.path");
		Path dir = Paths.get(path);
		System.out.println(path);
		// 两个星号**，像*一样工作，但跨越目录边界。这种语法通常用于匹配完整的路径。
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,class,jar,dll}")) {
		    for (Path entry: stream) {
		        System.out.println(entry.getFileName());
		    }
		} catch (IOException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can // only be thrown by newDirectoryStream.
		    System.err.println(x);
		} 
	}
}
