package course.regular.demo;

import java.util.Arrays;

public class Day2 {
	public static boolean hasLetter(String word, char letter)
	{
	    for (int i = 0; i < word.length(); i++)
	    {
	        if (word.charAt(i) == letter)
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static String replace(String word, char gone, char here) {
		char[] cArray = word.toCharArray();
		char[] cArrayMod = new char[cArray.length];
		int i = 0;
		for (char c : cArray) {
			if (c == gone)
				cArrayMod[i] = here;
			else
				cArrayMod[i] = c;
			i++;
		}
		return new String(cArrayMod);
	}
	public static void main(String[] args) {
		String s = "java1   java2";
		System.out.println(hasLetter(s, 'a'));
		System.out.println(s.indexOf("va"));
		System.out.println(s.split("( )+")[1]);
		System.out.println(replace(s, 'a', 'b'));
		
		String s2 = "1 2 33";
		String[] s2Arr = s2.split("[0-9]*");
		System.out.println(Arrays.deepToString(s2Arr));
		
		String s3 = "java1 java1.java2.java3!!!java4";
		String[] s3Arr = s3.split("[. ]");
		System.out.println("s3Arr length = " + s3Arr.length + " --> " + Arrays.deepToString(s3Arr));
		
		String s4 = "Hello";
		String ss = s4.concat(" World!");
		System.out.println(ss);
		
		String s5 = s4;
		System.out.println(s5 == s4);
	}
}
