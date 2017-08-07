package oracle.javase.tutorial.collections.interfaces.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Name implements Comparable<Name>{
	private final String firstName, lastName;
	public Name(String firstName, String lastName) {
		if(firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String firstName() { return firstName; }
    public String lastName()  { return lastName;  }
    
    @Override
    public boolean equals(Object obj) {
    	if(!(obj instanceof Name))
    		return false;
    	Name name = (Name)obj;
    	return name.firstName.equals(firstName) && name.lastName.equals(lastName);
    }
    
    @Override
    public int hashCode() {
    	return 31 * firstName.hashCode() + lastName.hashCode();
    }
    @Override
    public String toString() {
    	return firstName + " " + lastName;
    }
	@Override
	public int compareTo(Name o) {
		int lastCmp = lastName.compareTo(o.lastName);
		return lastCmp != 0 ? lastCmp : firstName.compareTo(o.firstName);
	}
	
	public static void main(String[] args) {
		List<Name> names = new ArrayList<Name>();
		names.add(new Name("sha", "quan5"));
		names.add(new Name("sha", "quan2"));
		names.add(new Name("sha", "quan3"));
		names.add(new Name("sha", "quan4"));
		names.add(new Name("sha", "quan1"));
		
		Collections.sort(names);
		
		System.out.println(names);
		System.out.println("quan4".hashCode() - "quan1".hashCode());
	}
	
}
