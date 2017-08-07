package oracle.javase.tutorial.datetime.iso.date;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DisplayWeekAmdMonth {
	public static void main(String[] args) {
System.out.printf("%s%n", DayOfWeek.MONDAY.plus(2));
		
		DayOfWeek dow = DayOfWeek.MONDAY;
		Locale locale = Locale.getDefault();
		System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
		System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
		
		System.out.println("------------------------------------------------------");
		Month month = Month.APRIL;
		System.out.println(month.getDisplayName(TextStyle.FULL, locale));
		System.out.println(month.getDisplayName(TextStyle.NARROW_STANDALONE, locale));
		System.out.println(month.getDisplayName(TextStyle.FULL_STANDALONE, locale));
		System.out.println(month.getDisplayName(TextStyle.SHORT_STANDALONE, locale));
	}
}
