package oracle.javase.tutorial.io;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExperiment {
	public static void main(String[] args) {
		Path p1 = Paths.get("/tmp/foo");
//		Path p2 = Paths.get(args[0]);
		Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
		Path p4 = FileSystems.getDefault().getPath("/users/sally");
		Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");
		// None of these methods requires that the file corresponding
		// to the Path exists.

		/*
		 * 	Solaris syntax:
		 * 	Path path = Paths.get("/home/joe/foo");
		 * 	Microsoft Windows syntax:
		 */
		Path path = Paths.get("C:\\home\\joe\\foo");
		
		System.out.printf("%-30s%s%n", "path.toString()", path.toString());
		System.out.format("%-30s%s%n", "path.getFileName()", path.getFileName());
		System.out.format("%-30s%s%n", "path.getName(0)", path.getName(0));
		System.out.format("%-30s%s%n", "path.getNameCount()", path.getNameCount());
		System.out.format("%-30s%s%n", "path.subpath(0, 2)", path.subpath(0,2));
		System.out.format("%-30s%s%n", "path.getParent()", path.getParent());
		System.out.format("%-30s%s%n", "path.getRoot()", path.getRoot());
		System.out.println(path.toUri());
	}
	
	
	public static String getMethodName(Object o){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();
		String callName = stack[2].getMethodName();
		return callName;
	}
}
