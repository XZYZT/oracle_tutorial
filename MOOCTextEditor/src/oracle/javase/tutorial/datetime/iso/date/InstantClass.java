package oracle.javase.tutorial.datetime.iso.date;

import java.security.AccessController;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.JulianFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.time.temporal.WeekFields;
import java.util.Locale;

import sun.security.action.GetPropertyAction;

public class InstantClass {
	public static void main(String[] args) {
		System.out.println(Instant.now());
		System.out.println(Instant.EPOCH);
		System.out.println(Instant.now().plusSeconds(60) + " after one hour");
		
		long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(),
                ChronoUnit.SECONDS);
		System.out.println(secondsFromEpoch);
		
		Instant timestamp = Instant.EPOCH;
		LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
		System.out.println(ZoneId.systemDefault());
		System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
		                  ldt.getYear(), ldt.getHour(), ldt.getMinute());
		
		String zoneID = AccessController.doPrivileged(new GetPropertyAction("user.timezone"));
		String javaHome = AccessController.doPrivileged(new GetPropertyAction("java.home"));
		System.out.println(System.getProperty("user.timezone"));
		System.out.println(LocalDate.now().isSupported(ChronoField.CLOCK_HOUR_OF_DAY));
		System.out.println(LocalDate.now().isSupported(JulianFields.JULIAN_DAY));
		
		Temporal t;
		TemporalAccessor ta;
		TemporalField tf = new TemporalField() {
			
			@Override
			public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ValueRange range() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isTimeBased() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isSupportedBy(TemporalAccessor temporal) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isDateBased() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public TemporalUnit getRangeUnit() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getFrom(TemporalAccessor temporal) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public TemporalUnit getBaseUnit() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <R extends Temporal> R adjustInto(R temporal, long newValue) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		System.out.println(tf.getDisplayName(Locale.CANADA));
		System.out.println("oracle.javase.tutorial.datetime.iso.date.InstantClass$1@2f4d3709".length());
	}
}
