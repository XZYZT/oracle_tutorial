package oracle.javase.tutorial.classes.lambda;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Ideal Use Case for Lambda Expressions
 * @author ShaQuan
 *
 */
public class Person {
	public enum Sex {
        MALE, FEMALE
    }
	
	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	
	public int getAge() {
		return birthday
				.until(IsoChronology.INSTANCE.dateNow())
				.getYears();
    }
	
	public Sex getGender(){
		return gender;
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setBirthday(LocalDate birthday){
		this.birthday = birthday;
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void printPerson() {
        System.out.println(name + " " + gender);
    }
	
    public static void printPersonsOlderThan(List<Person> roster, int age){
    	for(Person p : roster){
    		if(p.getAge() >= age){
    			p.printPerson();
    		}
    	}
    }
    public static void printPersonsWithinAgeRange(
	    List<Person> roster, int low, int high) {
	    for (Person p : roster) {
	        if (low <= p.getAge() && p.getAge() < high) {
	            p.printPerson();
	        }
	    }
	}
    
    @FunctionalInterface
    interface CheckPerson{
    	boolean test(Person p);
    }
    
    @FunctionalInterface
	interface Predicate<T>{
    	boolean test(T t);
    }
    
    public static void printPersons(
	    List<Person> roster, CheckPerson tester) {
	    for (Person p : roster) {
	        if (tester.test(p)) {
	            p.printPerson();
	        }
	    }
	}
    class CheckPersonEligibleForSelectiveService implements CheckPerson{
		@Override
		public boolean test(Person p) {
			return p.gender == Person.Sex.MALE && 
					p.getAge() >= 18 && 
					p.getAge() <= 25;
		}
    }

	
	public static void processPersons(
			List<Person> roster,
			Predicate<Person> tester,
			Consumer<Person> block){
		for(Person p : roster){
			if(tester.test(p)){
				block.accept(p);
			}
		}
	}
	
	public static void printPersonsWithPredicate(List<Person> roster,
			Predicate<Person> tester){
		for(Person p : roster){
			if(tester.test(p)){
				p.printPerson();
			}
		}
	}
	
	public static void processPersonsWithFunction(
			List<Person> roster,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> block){
		for(Person p : roster){
			if(tester.test(p)){
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	public static <X, Y> void processElements(
			Iterable<X> source,
			Predicate<X> tester,
			Function<X, Y> mapper,
			Consumer<Y> block){
		for(X p : source){
			if(tester.test(p)){
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	public static Person createOnePerson(){
		Person person = new Person(
	            "shaquan",
	            IsoChronology.INSTANCE.date(1998, 9, 8),
	            Person.Sex.MALE,
	            "940692313@qq.com");
		return person;
	}
	
	public Person() {}
	
	public Person(String name, LocalDate birthday, Sex gender, String eamil) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = eamil;
	}
	
	public static List<Person> createRoster() {
        
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, "bob@example.com"));
        
        return roster;
    }
	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();
		
		roster.add(createOnePerson());
		
		processPersons(roster, 
				p -> p.getGender() == Person.Sex.MALE
					&& p.getAge() >= 18
					&& p.getAge() <= 25, 
				p -> p.printPerson()
		);
		
		processPersonsWithFunction(roster, 
				p -> p.getGender() == Person.Sex.MALE
					&& p.getAge() >= 18 
					&& p.getAge() <= 25, 
				p -> String.valueOf(p.getAge()),
				age -> System.out.println(age));
		
		processElements(roster,
				p -> p.getGender() == Person.Sex.MALE,
				p -> p.getEmailAddress(),
				email -> System.out.println(email));
		
		printPersons(roster);
	}
	
	/**
	 * uses aggregate operations to print the e-mail addresses 
	 * of those members contained in the collection roster who 
	 * are eligible for Selective Service:
	 */
	public static void printPersons(List<Person> roster){
		roster
			.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE)
			.map(p -> p.getEmailAddress())
			.forEach(email -> System.out.println(email));
	}
	
	 public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}



