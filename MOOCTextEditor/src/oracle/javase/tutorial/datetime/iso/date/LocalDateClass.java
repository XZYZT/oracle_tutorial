package oracle.javase.tutorial.datetime.iso.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

public class LocalDateClass {
	public static void main(String[] args) {
//		LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
		LocalDate date = LocalDate.now();
		LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.printf("For the date of %s, the next Wednesday is %s.%n",
                date, nextWed);
		
		YearMonth date4 = YearMonth.now();
		System.out.printf("%s: %d%n", date, date4.lengthOfMonth());

		YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

		YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
		
		System.out.println(date3.isLeapYear());
		
		
		System.out.printf("now: %s%n", LocalDateTime.now());

		System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
		                  LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

		System.out.printf("now (from Instant): %s%n",
		                  LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

		System.out.printf("6 months from now: %s%n",
		                  LocalDateTime.now().plusMonths(6));

		System.out.printf("6 months ago: %s%n",
		                  LocalDateTime.now().minusMonths(6));
		
	}
}
