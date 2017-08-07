package oracle.javase.tutorial.collections.interfaces;

import java.util.HashSet;
import java.util.Set;



public class FindDups2 {
	public static void main(String[] args) {
		Set<String> uniques = new HashSet<String>();
		Set<String> dups = new HashSet<String>();
		
		for(String a : args){
			if(!uniques.add(a)){
				dups.add(a);
			}
		}
		
		uniques.removeAll(dups);
		
		System.out.println("Unique words:    	" + uniques);
        System.out.println("Duplicate words: 	" + dups);
        
        System.out.println("Symmetric different:	" + symmetricDiff(uniques, dups));
	}
	/**
	 * calculates the symmetric set difference of two sets nondestructively.
	 * ���ƻ��Եؼ�������ĶԳƼ��ϲ
	 */
	static Set<String> symmetricDiff(Set<String> s1, Set<String> s2){
		Set<String> symmetricDiff = new HashSet<String>(s1);
		symmetricDiff.addAll(s2);
		Set<String> tmp = new HashSet<String>(s1);
		tmp.retainAll(s2);//s1��s2�Ĳ���
		
		symmetricDiff.removeAll(tmp);
		return symmetricDiff;
	}
	
}
