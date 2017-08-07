package oracle.javase.tutorial.io.watching;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;
import oracle.javase.tutorial.io.metadata.LocalPath;
public class RegisterForEvent{
	static Path dir = LocalPath.DESPTOP_A.path();
	public static void main(String[] args) {
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
		    WatchKey key = dir.register(watcher,
		                           ENTRY_CREATE,
		                           ENTRY_DELETE,
		                           ENTRY_MODIFY);
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
}
