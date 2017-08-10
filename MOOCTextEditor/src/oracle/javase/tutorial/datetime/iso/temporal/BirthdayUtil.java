package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BirthdayUtil {
	public static void betweenYourBirthday(LocalDate birthday) {
		LocalDate today = LocalDate.now();

		LocalDate nextBDay = birthday.withYear(today.getYear());

		//If your birthday has occurred this year already, add 1 to the year.
		if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
		    nextBDay = nextBDay.plusYears(1);
		}

		Period p = Period.between(today, nextBDay);
		long p2 = ChronoUnit.DAYS.between(today, nextBDay);
		System.out.println("There are " + p.getMonths() + " months, and " +
		                   p.getDays() + " days until your next birthday. (" +
		                   p2 + " total)");
	}
}
