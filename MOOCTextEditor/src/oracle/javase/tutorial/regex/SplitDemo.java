package oracle.javase.tutorial.regex;

import java.util.regex.Pattern;

public class SplitDemo {
	 private static final String REGEX = "\\d";
	 private static final String INPUT =
			 "one1df3two2three3four4five5";
	 public static void main(String[] args) {
		 Pattern p = Pattern.compile(REGEX);
		 String[] items = p.split(INPUT);
		 System.out.println("Pattern.quote = " + Pattern.quote("[0-9]+$"));
		 for(String s : items) {
			 System.out.println(s);
		 }
	 }
}
