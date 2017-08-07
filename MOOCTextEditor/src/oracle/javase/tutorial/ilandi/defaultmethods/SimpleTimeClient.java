package oracle.javase.tutorial.ilandi.defaultmethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient implements TimeClient {
	private LocalDateTime dateAndTime;
	
	public SimpleTimeClient() {
        dateAndTime = LocalDateTime.now();
    }
    
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }
    
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(year, month, day);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(dateToSet, currentTime);
    }
    
    public void setDateAndTime(int day, int month, int year,
                               int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(year, month, day);
        LocalTime timeToSet = LocalTime.of(hour, minute, second); 
        dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
    }
    
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }
    
    public static LocalDateTime getCurrentDateTime(){
    	return LocalDateTime.now();
    }
    
    
    public String toString() {
        return dateAndTime.toString();
    }
    
    public static void main(String... args) {
        TimeClient myTimeClient = new SimpleTimeClient();
        myTimeClient.setDate(20, 7, 2016);
//        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
//        System.out.println(endOfFeb.getYear());
        
        System.out.println(myTimeClient.toString());
        System.out.println(SimpleTimeClient.getCurrentDateTime());
    }
}
