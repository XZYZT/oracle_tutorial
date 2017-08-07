package oracle.javase.tutorial.regex;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/**
 * http://docs.oracle.com/javase/tutorial/essential/regex/examples/RegexTestHarness.java
 * @author ShaQuan
 *
 */
public class RegexTestHarness1 {
	 public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
	        Console console = System.console();
	        if (console == null) {
	            System.err.println("No console.");
	            System.exit(1);
	        }
	        PrintWriter out = new PrintWriter("../oracle_tutorial/regex/regular.command.log", "utf-8");
	        while (true) {
	        	final int flags = Pattern.CASE_INSENSITIVE/*不区分大小写*/ | Pattern.UNIX_LINES;
	        	String readRegex = console.readLine("%nEnter your regex: ");
	        	Pattern pattern = null;
	        	Matcher matcher = null;
	        	try {
	        		pattern = Pattern.compile(readRegex, flags);
		            out.append(readRegex);
		            if(readRegex.toLowerCase().equals("exit")){
		            	out.close();
		            	console.format("exit sucessful!%n");
		            	System.exit(0);
		            }
		            matcher = pattern.matcher(console.readLine("Enter input string to search: "));
				} catch (PatternSyntaxException pse) {
					console.format("There is a problem with the regular expression!%n");
					console.format("The pattern problem is: %s%n", pse.getPattern());
					console.format("The discription is: %s%n", pse.getDescription());
					console.format("The message is: %s%n", pse.getMessage());
					console.format("The index is: %s%n", pse.getIndex());
					System.exit(0);
				}
	            
	            boolean found = false;
	            while (matcher.find()) {
	                console.format("I found the text" +
	                    " \"%s\" starting at " +
	                    "index %d and ending at index %d.%n",
	                    matcher.group(),
	                    matcher.start(),
	                    matcher.end());
	                found = true;
	            }
	            if(!found){
	                console.format("No match found.%n");
	            }
	            
	        }
	    }
}
