package oracle.javase.tutorial.datetime.iso.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class BirthDay {
	static LocalDateTime queCha = LocalDateTime.of(1992, 9, 8, 0, 0);
	static LocalDateTime now = LocalDateTime.now();
	static LocalDateTime daiDai = LocalDateTime.of(1993, 1, 22, 0, 0);
	
	private static long between(Temporal start, Temporal end) {
		return Duration.between(start, end).toDays();
	}
	
	public static void main(String[] args) {
		System.out.println(between(queCha, daiDai));
	}
}
