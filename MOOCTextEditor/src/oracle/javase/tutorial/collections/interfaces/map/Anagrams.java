package oracle.javase.tutorial.collections.interfaces.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Anagrams {
	public static void main(String[] args) {
		
		if(args.length == 0)
			args = new String[]{"oracle_tutorial/collection/dictionary.txt","5"};
		
		int minGroupSize = Integer.parseInt(args[1]);
		
		Map<String, List<String>> m = new HashMap<String, List<String>>();
		
		try {
			Scanner s = new java.util.Scanner(new File(args[0]));
			while(s.hasNext()){
				String word = s.next();
				String alpha = alphabetize(word);
				List<String> valueList = m.get(alpha);
				if(valueList == null){
					m.put(alpha, valueList = new ArrayList<String>());
				}
				valueList.add(word);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		for(List<String> l : m.values()){
//			if(l.size() >= minGroupSize){
//				System.out.println(l.size() + " : " + l);
//			}
//		}
		
		for(String key : m.keySet()){
			List<String> valueList = m.get(key);
			if(valueList.size() >= minGroupSize){
				System.out.println(key + " contains " +valueList.size()  + " words "   + " : " + valueList);
			}
		}
		
	}
	
	private static String alphabetize(String s){
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}
