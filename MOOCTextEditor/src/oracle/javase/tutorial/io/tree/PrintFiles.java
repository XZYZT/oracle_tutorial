package oracle.javase.tutorial.io.tree;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.*;
/**
 * http://docs.oracle.com/javase/tutorial/essential/io/walk.html
 * @author ShaQuan
 *
 */
public class PrintFiles extends SimpleFileVisitor<Path>{
	//Print information about each type of file
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if(attrs.isSymbolicLink()){
			System.out.format("Symbolic link: %s%n ", file);
		} else if(attrs.isRegularFile()){
			System.out.format("Regular file: %s%n ", file);
		} else {
			System.out.format("Others: %s%n ", file);
		}
		System.out.println("(" + attrs.size() + "bytes)");
		return CONTINUE;
	}
	// Print each directory visited.
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		System.out.format("Directory: %s%n", dir);
		return CONTINUE;
	}
	/*
	 * If there is some error accessing the file, let the user konw.
	 * If you don't override this method and an error occurs, an
	 * IOException is thrown.
	 */
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		if(exc instanceof FileSystemLoopException){
			System.err.println("cycle detected:" + file);
		} else {
			System.err.format("Unable to copy: + %s: %s%n", file, exc);
		}
		return CONTINUE;
	}
	public PrintFiles() {}
	private String skip = "SCSS";
	public PrintFiles(String skip) { 
		this.skip = skip;
	}
	
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if(skip.length() == 0 || skip == null){
			this.skip = "SCSS";
		}
		if (dir.getFileName().toString().equals(skip)) {
			return SKIP_SUBTREE;
		}
		return CONTINUE;
	}
}
