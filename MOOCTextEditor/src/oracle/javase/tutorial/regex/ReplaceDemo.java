package oracle.javase.tutorial.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo {
	private static String REGEX = "a*d";
	private static String INPUT = "addadasdafasd";
	private static String REPLACE = "-";
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher m = pattern.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);
		System.out.println(INPUT);
		
		StringBuffer sb = new StringBuffer(INPUT);
//		while(m.find()){
//			m.appendReplacement(sb, REPLACE);
//		}
		m.appendTail(sb);
		System.out.println(sb);
	}
}
