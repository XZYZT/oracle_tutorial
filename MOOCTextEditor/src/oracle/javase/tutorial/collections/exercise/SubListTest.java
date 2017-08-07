package oracle.javase.tutorial.collections.exercise;

import java.util.Arrays;
import java.util.List;

public class SubListTest {
	public static void main(String[] args) {
		String[] rank = new String[] {
            "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "10" 
        };
		List<String> rankList = Arrays.asList(rank);
		
		System.out.println(rankList.subList(2, rank.length));
		
		System.out.println((char)('a' ^ 0b0100000));
		
		System.out.println((char)0x46);
	}
}
