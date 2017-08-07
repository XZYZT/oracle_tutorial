package course.regular.demo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Day19 {
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1";
		System.out.println(s1 == s2);
		
		String s = "%one%%two%%%three%%%%";
		System.out.println(Arrays.deepToString(s.split("[one,two,three]")));
		
		String text = "My ";
		System.out.println(text.concat("String "));
		
		String s4 = "    ";
		int countSpace = mystery(s4);
		System.out.println(countSpace + ": " + s4);
	}
	public static int mystery(String s){
	    char[] letters = s.toCharArray();
	    int x = 0;
	    for (int i = 0; i < letters.length; i++) {
	        if (letters[i] == ' ') {
	           letters[i] = '_';
	           x++;
	        }
	    }
	    return x;
	}
	
}
