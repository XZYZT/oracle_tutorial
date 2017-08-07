package oracle.javase.tutorial.exception;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class TryBlock {
	private List<Integer> list;
	private static final int SIZE = 10;
	public void writeList() {
	    PrintWriter out = null;
	    try {
	        System.out.println("Entered try statement");
	        out = new PrintWriter(new FileWriter("OutFile.txt"));
	        list.set(0, 0);
	        for (int i = 0; i < SIZE; i++) {
	        	list.set(i, i);
//	            out.println("Value at: " + i + " = " + list.get(i));
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		TryBlock tb = new TryBlock();
		tb.writeList();
	}
}
