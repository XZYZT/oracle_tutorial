package oracle.javase.tutorial.datetime.iso.date;

import java.time.Year;
import java.time.temporal.ChronoField;

public class ChronoFieldEnum {
	public static void main(String[] args) {
		System.out.println(ChronoField.DAY_OF_MONTH);
		
		Year year = Year.now();
		System.out.println(year.atDay(59));
		
	}
}
