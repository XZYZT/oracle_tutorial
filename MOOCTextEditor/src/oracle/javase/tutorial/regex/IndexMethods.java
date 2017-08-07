package oracle.javase.tutorial.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexMethods {
	private static final String REGEX = "\\bcat\\b";//\\b†ÎÔ~ß…½ç
	private static final String INPUT = "cat cat cat cattie cat";
	private static Scanner scan;

	public static void main( String args[] ) {
		scan = new Scanner(System.in);
		String s = scan.nextLine();
		if(s == "exit"){
			System.out.println("== \"exit\"");
		}else if(s.equals("exit")){
			System.out.println("equals(\"exit\")");
		}
		
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);   // get a matcher object
		int count = 0;

		while(m.find()) {
			count++;
			System.out.println("Match number "+count);
			System.out.println("start(): "+m.start());
			System.out.println(m.group(0));
			System.out.println("end(): "+m.end());
		}
	}
}
