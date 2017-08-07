package oracle.javase.tutorial.io;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.FileVisitResult.*;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/examples/Copy.java
 * @author ShaQuan
 *
 */
public class Copy1 {
	static boolean okayToOverwrite(Path file){
		String answer = System.console().readLine("overwrite %s (yes/no)? ", file);
		return (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
	}
	
	static void copyFile(Path source, Path target, boolean prompt, boolean preserve){
		CopyOption[] options = (preserve) ? 
				new CopyOption[]{COPY_ATTRIBUTES, REPLACE_EXISTING} : 
				new CopyOption[]{REPLACE_EXISTING};
		if(!prompt || Files.notExists(target) || okayToOverwrite(target)){
			try {
				Files.copy(source, target, options);
			} catch (IOException e) {
				System.err.format("Unable to copy:%s: %s%n", source, e);
			}
		}
	}
	/**
     * A {@code FileVisitor} that copies a file-tree ("cp -r")
     */
	static class TreeCopier implements FileVisitor<Path>{
		private final Path source;
        private final Path target;
        private final boolean prompt;
        private final boolean preserve;/*保留*/
        TreeCopier(Path source, Path target, boolean prompt, boolean preserve) {
        	this.source = source;
        	this.target = target;
        	this.prompt = prompt;
        	this.preserve = preserve;
        }
        
        /**
         * 预访问目录
         */
        @Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) {
        	CopyOption[] options = (preserve) ?  
        			new CopyOption[]{COPY_ATTRIBUTES} : new CopyOption[0];
        	Path newdir = target.resolve(source.resolve(dir));
        	try {
				Files.copy(dir, newdir, options);
			} catch (FileAlreadyExistsException e) {
				System.out.println();
			} catch (IOException e) {
				System.err.format("Unable to create: %s: %s%n", dir, e);
				return SKIP_SUBTREE;
			}
			return CONTINUE;
		}
        /**
         * 访问文件
         */
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			copyFile(file, target.resolve(source.relativize(file)), 
					prompt, preserve);
			return CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc)
				throws IOException {
			if(exc instanceof FileSystemLoopException){
				System.out.println("cycle deleted: " + file);
			} else {
				System.err.format("Unable to copy all attributes to %s %s%n", file, exc);
			}
			return CONTINUE;
		}
		
		static void usage(){
			
		}
		/**
		 * 访问后的目录
		 */
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			if(exc == null && preserve){
				Path newdir = target.resolve(source.relativize(dir));
				try {
					FileTime time = Files.getLastModifiedTime(dir);
					Files.setLastModifiedTime(newdir, time);
				} catch (IOException e) {
					System.err.format("Unable to copy all attributes to: %s: %s%n", newdir, e);
				}
			}
			return CONTINUE;
		}
	}
	
	static void usage() {
        System.err.println("java Copy [-ip] source... target");
        System.err.println("java Copy -r [-ip] source-dir... target");
        System.exit(-1);
    }
	public static void main(String[] args) {
		boolean recursive = false;
		boolean prompt = false;
		boolean preserve = false;
		
		for(int argi = 0; argi < args.length; argi ++){
			String arg = args[argi];
			if(!arg.startsWith("-")) break;
			if(arg.length() < 2) usage();
			for(int i = 0; i < arg.length(); i ++){
				char c = arg.charAt(i);
				switch (c) {
				case 'r': recursive = true;
				case 'i' : prompt = true;
				case 'p' : preserve = true;
				default: break;
				}
			}
		}
		
		
	}
}
