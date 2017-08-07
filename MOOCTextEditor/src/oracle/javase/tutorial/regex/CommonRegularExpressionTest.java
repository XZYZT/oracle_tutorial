package oracle.javase.tutorial.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonRegularExpressionTest {
	static Pattern pattern = CommonRegularExpression.ZIP_CODE.pattern();
	public static boolean isZipCode(String text){
	    return pattern.matcher(text).matches();
	}
	public static void findZipCode(String text) {
	    Matcher matcher = pattern.matcher(text);
	    while (matcher.find()) {
	        System.out.println(matcher.group());
	    }
	}
	
	public static void main(String[] args) {
		 findZipCode("” ±‡ 100013£¨µÁª∞18612345678");
	}
}
