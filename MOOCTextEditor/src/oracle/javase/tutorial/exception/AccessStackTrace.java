package oracle.javase.tutorial.exception;

import java.io.IOException;

public class AccessStackTrace {
	public static void exceptionFun(){
    	String[] sArr = {"1", "2", "3"};
		for(int i = 0; i < 5; i ++){
			String s = sArr[i];
		}
    }
    
    public static void main(String[] args) throws IOException {
    	try {
    		exceptionFun();
		} catch (Exception cause) {
			StackTraceElement elements[] = cause.getStackTrace();
			for (int i = 0, n = elements.length; i < n; i++) {       
		        System.err.println(elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()");
		    }
		}
	}
}
