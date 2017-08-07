package oracle.javase.tutorial.io.tree;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import static java.nio.file.FileVisitOption.*;
import oracle.javase.tutorial.io.metadata.LocalPath;

public class KichstartingProcess {
	public static void main(String[] args) {
//		Path startingDir = LocalPath.DESPTOP_A.path();
		
		Path startingDir = Paths.get("lib");
		PrintFiles pf = new PrintFiles();
		try {
			Files.walkFileTree(startingDir, pf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		EnumSet<FileVisitOption> opts = EnumSet.of(FOLLOW_LINKS);
//		PrintFiles visitor = new PrintFiles();
//		try {
//			Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, visitor);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
