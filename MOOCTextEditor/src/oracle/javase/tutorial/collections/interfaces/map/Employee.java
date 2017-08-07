package oracle.javase.tutorial.collections.interfaces.map;

import java.util.Date;

public class Employee implements Comparable<Employee>{
	@Override
	public int compareTo(Employee o) {
		return 0;
	}
	public Name name()     { return null; }
    public int number()    { return 0; }
    public Date hireDate() { return null; }
}
