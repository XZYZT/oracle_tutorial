package oracle.javase.tutorial.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TwoPaths {
	public static void main(String[] args) {
		Path p1 = Paths.get("a");
		Path p2 = Paths.get("b/c");
		
		Path p1_to_p2 = p1.relativize(p2);
		Path p2_to_p1 = p2.relativize(p1);
		System.out.println(p1_to_p2);
		System.out.println(p2_to_p1);
		
		Path p3 = Paths.get("a/b");
		Path p3_to_p1 = p3.relativize(p1);
		Path p1_to_p3 = p1.relativize(p3);
		System.out.println(p3_to_p1);
		System.out.println(p1_to_p3);
		
		Path p = p1;
		System.out.println(p1.equals(p));
		
		System.out.println(p3.startsWith(p1));
		System.out.println(p3.startsWith(p2));
		
	}
}
