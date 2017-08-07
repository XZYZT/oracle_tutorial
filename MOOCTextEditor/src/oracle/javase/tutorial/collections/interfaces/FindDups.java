package oracle.javase.tutorial.collections.interfaces;

import java.util.*;

import oracle.javase.tutorial.collections.implementations.FileList;

public class FindDups {
	public static void main(String[] args) {
		Object[] fileList = FileList.readLine(FileList.path).toArray();
		
		Set<Object> s = distinctWords(fileList);
		
		System.out.println(s.size() + " distinct words: " + s);
		
    }
	
	public static Set<Object> distinctWords(Object[] objarr){
		
		Set<Object> set = new HashSet<Object>();
		for(Object s : objarr){
			set.add(s);
		}
		return set;
	}
}
