package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.*;

public class ClockClass {
	public static void main(String[] args) {
		System.out.println(Clock.systemUTC().instant());
		System.out.println(LocalDate.now().getDayOfWeek());
		
		LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
		JapaneseDate jdate     = JapaneseDate.from(date);
		HijrahDate hdate       = HijrahDate.from(date);
		MinguoDate mdate       = MinguoDate.from(date);
		ThaiBuddhistDate tdate = ThaiBuddhistDate.from(date);
		
		System.out.println(jdate);
		System.out.println(hdate);
	}
}
