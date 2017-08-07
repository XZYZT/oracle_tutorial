package oracle.javase.tutorial.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {
	public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }

        // Converts the input string to a Path object.
        Path inputPath = Paths.get(args[0]);
        
        // Converts the input Path
        // to an absolute path.
        // Generally, this means prepending
        // the current working
        // directory.  If this example
        // were called like this:
        //     java FileTest foo
        // the getRoot and getParent methods
        // would return null
        // on the original "inputPath"
        // instance.  Invoking getRoot and
        // getParent on the "fullPath"
        // instance returns expected values.
        inputPath.normalize();
        Path fullPath = inputPath.toAbsolutePath();
        //the real path of an existing file
        fullPath = fullPath.toRealPath();
        System.out.println(fullPath);
        
        Path p1 = Paths.get("/home/foo");
        System.out.printf("%s%n", p1.resolve("bar"));
        
        System.out.println(Paths.get("foo").resolve("/b"));
    }
}
