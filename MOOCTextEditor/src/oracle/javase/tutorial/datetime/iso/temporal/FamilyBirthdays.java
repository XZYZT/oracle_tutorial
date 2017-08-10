package oracle.javase.tutorial.datetime.iso.temporal;

import java.time.LocalDate;
import java.time.Month;
 
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ChronoField;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.io.IOException;
import java.lang.Boolean;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FamilyBirthdays implements People, DateVerification{
	public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day   = date.get(ChronoField.DAY_OF_MONTH);

        // Angie's birthday is on April 3.
        if ((month == Month.APRIL.getValue()) && (day == 3))
            return Boolean.TRUE;

        // Sue's birthday is on June 18.
        if ((month == Month.JUNE.getValue()) && (day == 18))
            return Boolean.TRUE;

        // Joe's birthday is on May 29.
        if ((month == Month.MAY.getValue()) && (day == 29))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }
	
	public FamilyBirthdays() throws IOException {
		String p ="bin/" + getCurrentDirectory(this) + "/birthday.txt";
		readBrithdayFromTxtFile(p);
	}
	public String getCurrentDirectory(Object o){
		String p = String.format("%s", Objects.requireNonNull(o)) ;
		return p.substring(0, p.lastIndexOf('.')).replace('.', '/');
	}
	/**
	 * 生日，姓名List
	 */
	private Map<String, String> birthdayDataBase = new HashMap<String, String>();
	
	public Map<String, String> getBirthdayDataBase() {
		return birthdayDataBase;
	}
	
	public List<String[]> getAllNamesAndBirthday(){
		Set<String> birthdays = birthdayDataBase.keySet();
		List<String[]> nameAndBirthday = new ArrayList<String[]>();
		
		for(String birthday : birthdays){
			String[] names = birthdayDataBase.get(birthday).split(",");
			for(String n : names)
				nameAndBirthday.add(new String[]{n, birthday});
		}
		return nameAndBirthday;
	}
	
	public boolean isDate(int[] date) {
		return true;
	}
	/**
	 * 
	 * @param name	
	 * @param regex 年月日分隔符
	 * @return
	 * @throws BirthdayException 
	 */
	public LocalDate getBirthday(String name, String regex) {
		for(String[] nab : getAllNamesAndBirthday()){
			if(nab[0].equals(name)){
				String dateS = nab[1];
				
				String[] birthdayS = dateS.split(regex);
				int[] date = toInt(birthdayS);
				
				return LocalDate.of(date[0], date[1], date[2]);
			}
		}
		
		return null;
	}
	
	private int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	private int[] toInt(String[] ss){
		int[] out = new int[ss.length];
		for(int i = 0; i < ss.length; i ++){
			out[i] = toInt(ss[i]);
		}
		return out;
	}
	
	public LocalDate getBirthday(String name)  {
		return getBirthday(name, "\\.");
	}
	
	
	public boolean havaName(String name){
		for(String[] n : getAllNamesAndBirthday()){
			if(n[0].equals(name))
				return true;
		}
		return false;
	}
	/**
	 * 若名字存在返回true,若名字不存在返回false
	 * @param name
	 * @param dbname
	 * @return
	 */
	private boolean haveName(String name, String[] dbname){
		if(dbname == null)
			return false;
		for(String n : dbname){
			System.out.printf("%15s%15s%15s%n", n, name, n.equals(name));
			if(n.equals(name)){
				return true;
			}
		}
		return false;
	}
	
	private void readBrithdayFromTxtFile(String p) throws IOException {
		List<String> list =  Files.readAllLines(Paths.get(p));
		for(String s : list){
			String birthday = s.split("=")[0];
			String nameFromFile = s.split("=")[1];
			String nameFromDb = birthdayDataBase.get(birthday);
			if(nameFromDb == null)
				birthdayDataBase.put(birthday, nameFromFile);
			else if(!haveName(nameFromFile, nameFromDb.split(","))){//预知姓名在同一天生日里姓名是否已经存在
				birthdayDataBase.put(birthday, nameFromDb += "," + nameFromFile);
			}
		}
	}
	
	public void betweenYourBirthday(LocalDate birthday) {
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
	
	
	public static void main(String[] args) throws IOException {
//		System.out.println(isFamilyBirthday(MonthDay.of(Month.APRIL, 3)));
		
	}

	
}

@SuppressWarnings("serial")
class NoSuchBabyException extends Exception{
	
}

class DateException extends Exception{
	
}

