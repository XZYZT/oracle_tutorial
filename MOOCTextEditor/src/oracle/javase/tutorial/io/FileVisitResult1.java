package oracle.javase.tutorial.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileVisitResult1 {
	public static void main(String[] args) {
		Path p1 = Paths.get("1/12");
		Path p2 = Paths.get("2/22");
		
		System.out.println(p1.resolve(p2));
		System.out.println(p1.resolve(p1));
		System.out.println(p2.resolve(p1));
		System.out.println(p2.resolve(p2));
		System.out.println(p1.relativize(p2));
		System.out.println(p2.relativize(p1));
		
		
		Path p3 = Paths.get("/home/sally/../joe/foo");
		System.out.println(p3.normalize());
		Path p4 = Paths.get("/home/./joe/foo");
		System.out.println(p4.normalize());
	}
}
