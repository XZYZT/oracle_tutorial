package oracle.javase.tutorial.datetime.iso.temporal;

import java.io.IOException;

public class FamilyBirthDay {
	int year;
	int month;
	int day;
	
	private FamilyBirthDay(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	private FamilyBirthDay(People p, String name) {
		
	}
	
	public static void main(String[] args) throws IOException, NoSuchBabyException {
		FamilyBirthdays fb = new FamilyBirthdays();
		System.out.println(fb.getBirthday("linxiaodai"));
		fb.betweenYourBirthday(fb.getBirthday("linxiaodai"));
	} 
	
}