package oracle.javase.tutorial.java.javaoo.enumeration;

public class EnumTest {
	Day day;
	public EnumTest(Day day) {
		this.day = day;
	}
	
	public void tellItLikeItIs(){
		switch (day) {
		case MONDAY : System.out.println("Mondays are bad."); break;
		case TUESDAY: System.out.println("Tuesday are best."); break;
		case SUNDAY : System.out.println("Sunday are nice"); break;
		case FRIDAY : System.out.println("FRIDAY are better"); break;
		default: System.out.println("Midweek days are so-so."); break;
		}
	}
	public static void main(String[] args) {
		EnumTest firstDay = new EnumTest(Day.FRIDAY);
		firstDay.tellItLikeItIs();
		
	}
}
