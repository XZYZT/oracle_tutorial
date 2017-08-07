package oracle.javase.tutorial.collections.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import com.sun.glass.ui.CommonDialogs.Type;

public class Shuffle<E> {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		for(String a : args){
//			list.add(a);
//		}
//		Collections.shuffle(list, new Random());
//		
//		ListInterface.shuffle(list, new Random());
//		System.out.println(list);
		
		List<String> list = Arrays.asList(args);
        Collections.shuffle(list);
        System.out.println(list);
        
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            String t = it.previous();
        }
	}
	
	public static <E> void replace(List<E> list, E val, List<? extends E> newVals) {
	    for (ListIterator<E> it = list.listIterator(); it.hasNext(); ){
	        if (val == null ? it.next() == null : val.equals(it.next())) {
	            it.remove();
	            for (E e : newVals)
	                it.add(e);
	        }
	    }
	}

}
