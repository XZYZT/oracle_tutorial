package oracle.javase.tutorial.datetime.iso.temporal;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
 
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextPayDay {
	public static void main(String[] args) {
		Month month = null;
        LocalDate date = null;
        DateTimeFormatter format;
        String out = null;
        if (args.length < 2){
            System.out.printf("Usage: NextPayday <month> <day>%n");
            throw new IllegalArgumentException();
        }
 
        try {
            month = Month.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException exc) {
            System.out.printf("%s is not a valid month.%n", args[0]);
            throw exc;   // Rethrow the exception.
        }
 
        int day = Integer.parseInt(args[1]);
 
        try {
            date = Year.now().atMonth(month).atDay(day);
        } catch (DateTimeException exc) {
            System.out.printf("%s %s is not a valid date.%n", month, day);
            throw exc;   // Rethrow the exception.
        }
 
        LocalDate nextPayday = date.with(new PaydayAdjuster());
 
        try {
            format = DateTimeFormatter.ofPattern("yyyy MMM d");
            out = date.format(format);
            System.out.printf("Given the date:  %s%n", out);
            out = nextPayday.format(format);
            System.out.printf("the next payday: %s%n", out);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", out);
            throw exc;
        }
	}
}

class PaydayAdjuster implements TemporalAdjuster {
    
    /**
     * The adjustInto method accepts a Temporal instance
     * and returns an adjusted LocalDate. If the passed in
     * parameter is not a LocalDate, then a DateTimeException is thrown.
     */
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