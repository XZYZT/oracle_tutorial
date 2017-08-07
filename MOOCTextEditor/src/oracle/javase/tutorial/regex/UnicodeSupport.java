package oracle.javase.tutorial.regex;

import java.lang.Character.UnicodeScript;

public class UnicodeSupport {
	static int codePoint = 2546;
	static String hexPattern = "\\x{" + Integer.toHexString(codePoint) + "}";
	public static void main(String[] args) {
		System.out.println(hexPattern);
		UnicodeScript u = UnicodeScript.forName("javascript");
	}
}
