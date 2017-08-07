package oracle.javase.tutorial.io.dir;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class ListEnvironment {
	public static void main(String[] args) {
		/**
		 * java系统变量
		 */
		Properties properties = System.getProperties();
		Set<Object> pSet = System.getProperties().keySet();
		for(Object o : pSet){
			System.out.printf("%s = %s\n", o, properties.get(o));
		}
		/**
		 * OS环境变量
		 */
		Set<Entry<String, String>> sm = System.getenv().entrySet();
		Iterator<Entry<String, String>> it = sm.iterator();
        while (it.hasNext()){
        	Entry<String, String> entry = it.next();
        	System.out.printf("%s = %s\n", entry.getKey(), entry.getValue());
        }
	}
}
