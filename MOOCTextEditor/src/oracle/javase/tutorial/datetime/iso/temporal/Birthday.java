package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.Temporal;

public class Birthday {
	static LocalDate queCha = LocalDate.of(1992, 9, 8);
	static LocalDate now = LocalDate.now();
	static LocalDate daiDai = LocalDate.of(1993, 1, 22);
	
	private static long between(Temporal start, Temporal end) {
		return Duration.between(start, end).toDays();
	}
	
	public static void main(String[] args) {
		System.out.println(between(queCha, daiDai));
	}
}
