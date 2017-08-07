package oracle.javase.tutorial.io.watching;

import java.nio.file.Path;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class Resolve {
	public static void main(String[] args) throws Exception{
		Path p1 = LocalPath.DESPTOP_A.path();
		Path p2 = LocalPath.USER_DIR.path();
		
		
		System.out.println(p2.resolve(p1));
	}
}
