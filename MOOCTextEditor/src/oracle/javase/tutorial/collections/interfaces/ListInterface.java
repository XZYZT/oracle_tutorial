package oracle.javase.tutorial.collections.interfaces;

import java.util.List;
import java.util.Random;

public class ListInterface {
	public static <E> void swap(List<E> a, int i, int j){
		E tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	public static void shuffle(List<?> list, Random rnd){
		for(int i = list.size(); i > 1; i --){
			swap(list, i - 1, rnd.nextInt(i));
		}
	}
}
