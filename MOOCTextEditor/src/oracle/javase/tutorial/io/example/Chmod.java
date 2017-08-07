package oracle.javase.tutorial.io.example;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;

import static java.nio.file.attribute.PosixFilePermission.*;
import static java.nio.file.FileVisitResult.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * http://docs.oracle.com/javase/tutorial/essential/io/examples/Chmod.java
 * 
 * chomd 法格式为：chmod [who] [opt] [mode] 文件/目录名 
 * 	其中who表示对象，是以下字母中的一个或组合： 
	u：表示文件所有者 
	g：表示同组用户 
	o：表示其它用户 
	a：表示所有用户 
	opt则是代表操作，可以为： 
	+：添加某个权限 
	-：取消某个权限 
	=：赋予给定的权限，并取消原有的权限 
	而mode则代表权限： 
	r：可读 
	w：可写 
	x：可执行 
 * 
 * 示例 java oracle.javase.tutorial.io.chmod.Chmod g+rw a.txt 
 * @author ShaQuan
 *
 */
public class Chmod {
	/**
	 * 可用于更改一组文件权限。此方法以以类似于UNIX chmod 程序的方式更改文件权限。
	 * 更改文件权限的地方。
	 * @param exprs
	 * 			一个或多个符号模式表达式的列表
	 * @return
	 */
	public static Changer compile(String exprs){
		// minimum is who and operator (u= for example)
		if(exprs.length() < 2) throw new IllegalArgumentException("Invalid mode");
		
		final Set<PosixFilePermission> toAdd = new HashSet<PosixFilePermission>();
		final Set<PosixFilePermission> toRemove = new HashSet<PosixFilePermission>();
		
		for(String expr : exprs.split(",")){
			if(expr.length() < 2) throw new IllegalArgumentException("Invalid mode");
			
			int pos = 0;
			
			//who
			boolean u = false;
			boolean g = false;
			boolean o = false;
			boolean done = false;
			for(;;){
				switch (expr.charAt(pos)) {
					case 'u': u = true; break;
					case 'g': g = true; break;
					case 'o': o = true; break;
					case 'a': u = true; g = true; o = true; break;
					default: done = true; break;
				}
				if(done) break;
				pos ++;
			}
			if(!u && !g && !o) throw new IllegalArgumentException("Invalid mode");
			
			//get operator and permissions
			char op = expr.charAt(pos ++);
			String mask = (expr.length() == pos) ? "" : expr.substring(pos);
			
			//operator
			boolean add = (op == '+');
			boolean remove = (op == '-');
			boolean assign = (op == '=');
			if(!add && !remove && !assign) throw new IllegalArgumentException("Invalid mode");
			
			//who = means remove all
			if(assign && mask.length() == 0){
				assign = false;
				remove = true;
				mask = "rwx";
			}
			
			boolean r = false;
			boolean w = false;
			boolean x = false;
			
			for(int i = 0; i < mask.length(); i ++){
				switch (mask.charAt(i)) {
				case 'r': r = true; break;
				case 'w': w = true; break;
				case 'x': x = true; break;
				default:
					throw new IllegalArgumentException("Invalid mode");
				}
			}
			
			if(add){
				if(u){
					if(r) toAdd.add(OWNER_READ);
					if(w) toAdd.add(OWNER_WRITE);
					if(x) toAdd.add(OWNER_EXECUTE);
				}
				if(g){
					if(r) toAdd.add(GROUP_READ);
					if(w) toAdd.add(GROUP_WRITE);
					if(x) toAdd.add(GROUP_EXECUTE);
				}
				if(o){
					if(r) toAdd.add(OTHERS_READ);
					if(w) toAdd.add(OTHERS_WRITE);
					if(x) toAdd.add(OTHERS_EXECUTE);
				}
			}//end add
			if(remove){
				if(u){
					if(r) toRemove.add(OWNER_READ);
					if(w) toRemove.add(OWNER_WRITE);
					if(x) toRemove.add(OWNER_EXECUTE);
				}
				if(g){
					if(r) toRemove.add(GROUP_READ);
					if(w) toRemove.add(GROUP_WRITE);
					if(x) toRemove.add(GROUP_EXECUTE);
				}
				if(o){
					if(r) toRemove.add(OTHERS_READ);
					if(w) toRemove.add(OTHERS_WRITE);
					if(x) toRemove.add(OTHERS_EXECUTE);
				}
			}//end remove
			if(assign){
				if(u){
					if(r) toAdd.add(OWNER_READ);
					else toRemove.add(OWNER_READ);
					if(w) toAdd.add(OWNER_WRITE);
					else toRemove.add(OWNER_WRITE);
					if(x) toAdd.add(OWNER_EXECUTE);
					else toRemove.add(OWNER_EXECUTE);
				}
				if(g){
					if(r) toAdd.add(GROUP_READ);
					else toRemove.add(GROUP_READ);
					if(w) toAdd.add(GROUP_WRITE);
					else toRemove.add(GROUP_WRITE);
					if(x) toAdd.add(GROUP_EXECUTE);
					else toRemove.add(GROUP_EXECUTE);
				}
				if(o){
					if(r) toAdd.add(OTHERS_READ);
					else toRemove.add(OTHERS_READ);
					if(w) toAdd.add(OTHERS_WRITE);
					else toRemove.add(OTHERS_WRITE);
					if(x) toAdd.add(OTHERS_EXECUTE);
					else toRemove.add(OTHERS_EXECUTE);
				}
			}//end assign
		}//end for exprs
		return new Changer() {
			@Override
			public Set<PosixFilePermission> change(Set<PosixFilePermission> perms) {
				perms.addAll(toAdd);
				perms.removeAll(toRemove);
				return perms;
			}
		};
	}//end compiler
	
	
	public interface Changer {
		/**
		 * Applies the changes to the given set of permissions.
		 * 
		 * @param perm
		 * 			The set of permissions to change
		 * 
		 * @return	The {@code perms} parameter
		 */
		Set<PosixFilePermission> change(Set<PosixFilePermission> perms);
	}
	
	/**
	 *  Changes the permissions of the file using the given Changer.
	 */
	static void chmod(Path file, Changer changer){
		try {
			Set<PosixFilePermission> perms = Files.getPosixFilePermissions(file);
			Files.setPosixFilePermissions(file, changer.change(perms));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * Changes the permission of each file and directory visited
	 */
	static class TreeVisitor implements FileVisitor<Path>{
		private final Changer changer;
		
		TreeVisitor(Changer changer) {
			this.changer = changer;
		}
		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			chmod(dir, changer);
			return CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			chmod(file, changer);
			return CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc)
				throws IOException {
			System.err.println("WARNING: " + exc);
			return CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			if(exc != null) System.err.println("WARNING: " + exc);
			return CONTINUE;
		}
	}
	
	static void usage(){
		System.err.println("java Chmod [-R] symbolic-mod-list file...");
		System.exit(-1);
	}
	public static void main(String[] args)  throws IOException{
		if(args.length < 2) usage();
		int argi = 0;
		int maxDepth = 0;
		if(args[argi].equals("-R")){
			if(args.length < 3) usage();
			argi ++;
			maxDepth = Integer.MAX_VALUE;
		}
		Changer changer = compile(args[argi ++]);
		TreeVisitor visitor = new TreeVisitor(changer);
		
		Set<FileVisitOption> opts = Collections.emptySet();
		while(argi < args.length){
			Path file = Paths.get(args[argi]);
			Files.walkFileTree(file, opts, maxDepth, visitor);
			argi ++;
		}
		
		
	}
}

