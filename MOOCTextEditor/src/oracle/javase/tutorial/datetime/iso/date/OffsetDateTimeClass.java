package oracle.javase.tutorial.datetime.iso.date;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class OffsetDateTimeClass {
	
	
	static int maxLength = 0;
	
	static void compareSetMaxLength(int num){
		if(num > maxLength)
			maxLength = num;
	}
	
	
	/**
	 * 根据输入时间得到各时区时间
	 * 需要指定时间字符串和对应的时间格式
	 * @param dateTime
	 */
	public static List<String> printZoneTime(final String dateTime, DateTimeFormatter formatter){
		List<String> zoneIds = TimeZoneId.timeZones();
		
		for(int i = 0; i < zoneIds.size(); i ++){
			final String zoneId = zoneIds.get(i);
			
			final ZonedDateTime parsed = ZonedDateTime.parse(dateTime, formatter.withZone(ZoneId.of(zoneId)));
			zoneIds.remove(i);
			zoneIds.add(i, stringFormat(zoneId, parsed.toString()));
		}
		return zoneIds;
	}
	
	public static String stringFormat(String...s){
		StringBuilder out = new StringBuilder();
		for(int i = 0; i < s.length; i ++){
			compareSetMaxLength(s[i].length() + 2);
			out.append(String.format("%" + maxLength + "s", s[i]));
		}
		return out.toString();
	}
	
	
	public static void main(String[] args) {
		
		final String dateTime = "2017-02-22T02:06:58.147Z";
		DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
		String s = TimeZoneId.listToString(
				printZoneTime(dateTime, formatter), "\n");
		Path p = Paths.get("oracle_tutorial/datetime/zoneTimes");
		System.out.println(s);
		TimeZoneId.writeTimeZones(p, s);
	    
		
		printLastThursday();
		flight() ;
	}
	
	private static void flight() {
		ZoneId leavingZone = ZoneId.of("America/New_York");
		ZonedDateTime departure = ZonedDateTime.of(LocalDateTime.now(), leavingZone);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
		
		try {
			System.out.printf("LEAVING:  %s (%s)%n", departure.format(format), leavingZone);
		}catch (DateTimeException exc) {
		    System.out.printf("%s can't be formatted!%n", departure);
		    throw exc;
		}
		
		ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime arrival = departure.withZoneSameLocal(arrivingZone).plusHours(11);
		
		try {
			System.out.printf("ARRIVING: %s (%s)%n",arrival.format(format) ,arrivingZone);
		} catch (DateTimeException e) {
			System.out.printf("%s can't be formatted!%n", arrival);
		}
		
		
		if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) 
            System.out.printf("  (%s daylight saving time will be in effect.)%n",
                              arrivingZone);
        else
            System.out.printf("  (%s standard time will be in effect.)%n",
                              arrivingZone);
		
	}
	
	
	/**
	 * 打印本月最后一个周四
	 */
	public static void printLastThursday() {
		LocalDateTime localDate = LocalDateTime.of(2000, 2, 1, 0, 0);
		ZoneOffset offset = ZoneOffset.of("-08:00");
		
		OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
		OffsetDateTime lastThursday = 
		        offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
		System.out.printf("The last Thursday in %s is the %sth.%n", localDate, lastThursday.getDayOfMonth());
	}
	
	
	/**
	 * yyyy MM dd
	 * @param input
	 * @return
	 */
	public static LocalDateTime parse(String input){
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" MM dd yyyy");
			LocalDateTime date = LocalDateTime.parse(input, formatter);
			return date;
		} catch (DateTimeException e) {
			System.out.printf("%s is not parsable!%n", input);
		    throw e;
		}
	}
	
	
	
}
