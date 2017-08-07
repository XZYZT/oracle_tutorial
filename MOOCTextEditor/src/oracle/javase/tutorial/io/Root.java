package oracle.javase.tutorial.io;

public class Root {
	public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
        
        System.out.format("%f, %<+020.10f %n", Math.PI);
        System.out.format("%f, %1$+020.10f %n", Math.PI);
    }
}
