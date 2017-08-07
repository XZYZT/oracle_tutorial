package my.utils;


public class DataUtilsExperiment {
	public static String toHexString(int data){
		return Integer.toHexString(data);
	}
	public static String toHexString(short data){
		return toHexString(Short.toUnsignedInt(data));
	}
	public static void main(String[] args) {
		System.out.println(true | false);
		System.out.printf("%d - %d = %d%n", (int)'a', (int)'A', 'a' - 'A');
		for(int i = (int)'A'; i <= (int)'Z'; i ++){
			System.out.println((char)(i + 32));
		}
	}
}
