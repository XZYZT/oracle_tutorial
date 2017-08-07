package oracle.javase.tutorial.collections.interfaces.map;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpSort {
	static final Comparator<Employee> SENIORITY_ORDER = 
			new Comparator<Employee>() {
				public int compare(Employee o1, Employee o2) {
					return o1.hireDate().compareTo(o2.hireDate());
				}
			};
	//Employee database
	static final Collection<Employee> employees = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		List<Employee> e = new ArrayList<Employee>(employees);
		Collections.sort(e, SENIORITY_ORDER);
		System.out.println(e);
		
	}
}
