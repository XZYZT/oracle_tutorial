package oracle.javase.tutorial.collections.streams;

import java.util.List;

import oracle.javase.tutorial.classes.lambda.Person;
/**
 * http://docs.oracle.com/javase/tutorial/collections/streams/index.html#pipelines
 * Pipelines and Streams
 * A pipeline contains the following components:
 * 1. A source
 * 2. Zero or more intermediate operations. An intermediate operation, such as filter, produces a new stream.
 * 3. A terminal operation.
 * @author ShaQuan
 *
 */
public class PipAndStream {
	public static double averageAge(List<Person> roster){
		double average = roster.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();
		return average;
	}
	
	/**
	 * Differences Between Aggregate Operations and Iterators
	 * 1. They use internal iteration 
	 * 2. They process elements from a stream 
	 * 3. They support behavior as parameters 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		System.out.println(averageAge(roster));
		
	}
}
