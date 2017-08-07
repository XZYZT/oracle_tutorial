package oracle.javase.tutorial.io.tree;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;

import oracle.javase.tutorial.io.metadata.LocalPath;
/**
 * Finding Files: http://docs.oracle.com/javase/tutorial/essential/io/find.html
 * Glob: http://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob
 * @author ShaQuan
 *
 */
public class Find1 {
	
	public static class Finder extends SimpleFileVisitor<Path>{
		private final PathMatcher matcher;
		private int numMatches = 0;
		public Finder(String regex) {
			this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + regex);
		}
		//Compares the glob pattern against the file or directory name
		void find(Path file){
			Path name = file.getFileName();
			
			if(name != null && matcher.matches(name)){
				numMatches ++;
				System.out.println(file);
			}
		}
		//Prints the total number of matches to standard out.
		void done(){
			
		}
		//Invoke the pattern matching method on each file.
		
		
	}
}
