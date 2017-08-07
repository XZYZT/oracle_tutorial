package oracle.javase.tutorial.io.other;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

import oracle.javase.tutorial.io.metadata.LocalPath;

public class DefaultFileSystem {
	public static void main(String[] args) {
		PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:*.*");
		System.out.println(pm.matches(LocalPath.DESPTOP_A_FILE.path()));
	}
}
