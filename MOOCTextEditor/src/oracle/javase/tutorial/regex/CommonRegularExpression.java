package oracle.javase.tutorial.regex;

import java.util.regex.Pattern;
/**
 * http://www.cnblogs.com/swiftma/p/7062987.html
 * @author ShaQuan
 *
 */
public enum CommonRegularExpression {
	ZIP_CODE("(?<![0-9])[1-9][0-9]{5}(?![0-9])"),
	MOBILE_PHONE("1[3|4|5|7|8|][0-9]-?[0-9]{4}-?[0-9]{4}");
	private String regex;
	private CommonRegularExpression(String regex) {
		this.regex = regex;
	}
	public String getRegex(){
		return regex;
	}
	public Pattern pattern(){
		return Pattern.compile(regex);
	}
}
