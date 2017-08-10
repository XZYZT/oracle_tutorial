package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {
	public static void main(String[] args) {
		Instant start = Instant.ofEpochMilli(System.currentTimeMillis());
		Duration gap = Duration.ofSeconds(10);
		Instant later = start.plus(gap);
		System.out.printf("start=%s\nlater=%s.\n", start, later);
		
		Instant previous = start.minus(Duration.ofSeconds(10)), current;
		current = Instant.now();
		if (previous != null) {
		    long gap1 = ChronoUnit.MILLIS.between(previous,current);
		    System.out.println(gap1);
		}
		PeriodClass.main(args);
	}
}
class PeriodClass{
	public static void printYourOld(int year, int month, int day) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, day);

		Period p = Period.between(birthday, today);
		long p2 = ChronoUnit.DAYS.between(birthday, today);
		System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
		                   " months, and " + p.getDays() +
		                   " days old. (" + p2 + " days total)");
	}
	
	public static void main(String[] args) {
		printYourOld(1992, 9, 8);
	}
}