package oracle.javase.tutorial.io.metadata;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStoreAttributesTest {
	public static void main(String[] args) throws IOException {
		Path file = LocalPath.E_MYDIR.path();
		FileStore store = Files.getFileStore(file);
		long total = store.getTotalSpace();
		long avail = store.getUsableSpace();
		long unallocated = store.getUnallocatedSpace();
		long used = (total - unallocated);
		System.out.println((float)unallocated / 1024 / 1024 / 1024);
	}
}
