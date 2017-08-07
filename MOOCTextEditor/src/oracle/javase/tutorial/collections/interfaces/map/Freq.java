package oracle.javase.tutorial.collections.interfaces.map;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Freq {
	public static void main(String[] args) {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		
		for(String s : args){
			Integer freq = m.get(s);
			m.put(s, freq == null ? 1 : freq + 1);
		}
		
		System.out.println(m.size() + "distinct words:");
		System.out.println(m);
	}
	/**
	 * http://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
	 * @param attrMap
	 * @param requireAttrs
	 * @param permittedAttrs
	 * @return
	 */
	static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requireAttrs, Set<K> permittedAttrs){
		boolean valid = true;
		Set<K> attrs = attrMap.keySet();
		
		if(attrs.containsAll(requireAttrs)){
			Set<K> missing = new HashSet<K>(requireAttrs);
			missing.removeAll(attrs);
			System.out.println("Missing attributes: " + missing);
			valid = false;
		}
		
		if(!permittedAttrs.containsAll(attrs)){
			Set<K> illegal = new HashSet<K>(attrs);
			illegal.removeAll(permittedAttrs);
			System.out.println("Illegal attributes: " + illegal);
			valid = false;
		}
		return valid;
	}
}