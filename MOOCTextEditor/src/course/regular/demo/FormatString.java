package course.regular.demo;

public class FormatString {
	public static void main(String[] args) {
		String fs;
		float floatVar = 10.44f;
		int intVar = 10;
		String stringVar = " ";
		fs = String.format("The value of the float " +
		                   "variable is %f, while " +
		                   "the value of the " + 
		                   "integer variable is %d, " +
		                   " and the string is %s",
		                   floatVar, intVar, stringVar);
		System.out.println(fs);
	}
}
