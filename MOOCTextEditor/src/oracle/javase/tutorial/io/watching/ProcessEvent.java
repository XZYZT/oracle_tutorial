package oracle.javase.tutorial.io.watching;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import oracle.javase.tutorial.io.metadata.LocalPath;
import static java.nio.file.StandardWatchEventKinds.*;
public class ProcessEvent {
	private final WatchService watcher;
	private Path dir = LocalPath.DESPTOP_A.path();
	public ProcessEvent() throws IOException {
		watcher = FileSystems.getDefault().newWatchService();
		try {
		    WatchKey key = dir.register(watcher,
		                           ENTRY_CREATE,
		                           ENTRY_DELETE,
		                           ENTRY_MODIFY);
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
	
	public void process() throws IOException{
		for(;;){
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException  e) {
				return;
			}
			for(WatchEvent<?> event : key.pollEvents()){
				WatchEvent.Kind<?> kind = event.kind();
				if(kind == OVERFLOW){
					continue;
				}
				@SuppressWarnings("unchecked")
				WatchEvent<Path> ev = (WatchEvent<Path>)event;
				Path filename = ev.context();
				
				try {
					Path child = dir.resolve(filename);
					if (!Files.probeContentType(child).equals("text/plain")) {
		                System.err.format("New file '%s' is not a plain text file.%n", filename);
		                continue;
		            }
				} catch (IOException e) {
					System.out.println(e);
					continue;
				}
				System.out.format("Emailing file %s%n", filename);
			}
			
			boolean valid = key.reset();
		    if (!valid) {
		        break;
		    }
		}//end for
	}
	public static void main(String[] args) throws IOException {
		ProcessEvent api = new ProcessEvent();
		api.process();
	}
}
