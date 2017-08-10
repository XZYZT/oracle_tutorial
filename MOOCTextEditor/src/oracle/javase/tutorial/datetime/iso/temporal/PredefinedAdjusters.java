package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PredefinedAdjusters {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2000, 1, 10);
		DayOfWeek dotw = date.getDayOfWeek();
		System.out.printf("%s is on a %s%n", date, dotw);

		System.out.printf("first day of Month: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.printf("first Monday of Month: %s%n",
		                  date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.printf("last day of Month: %s%n",
		                  date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.printf("first day of next Month: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.printf("first day of next Year: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.printf("first day of Year: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfYear()));
		
		System.out.println(date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
		
	}
	
	public Temporal adjustInto(Temporal input) {
	    LocalDate date = LocalDate.from(input);
	    int day;
	    if (date.getDayOfMonth() < 15) {
	        day = 15;
	    } else {
	    	day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
	    }
	    date = date.withDayOfMonth(day);
	    if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
	        date.getDayOfWeek() == DayOfWeek.SUNDAY) {
	        date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
	    }
	    return input.with(date);
	}
}
