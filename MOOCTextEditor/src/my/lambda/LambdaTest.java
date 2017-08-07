package my.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LambdaTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println((int)'我');
		System.out.println((byte)'我');
		System.out.println(Character.isDigit(25105));
		ArrayList<String> list = new ArrayList<>();  
        list.add("lala");  
        list.add("haha");  
        list.forEach(ele1 -> System.out.println(ele1)); // 可以看到取出的ele无需强制类型转换，直接就是String类型的
        
        HashMap<String, Integer> map = new HashMap<>();  
        map.put("abc", 15);  
        map.put("def", 88);  
        map.put("directory", 235);
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        
        Callable<String> c = ()->{
        	System.out.println("11");
        	return "11111";
        };
	    Runnable r1 = () -> {System.out.println("Hello Lambda!");};
	    Object oc = (Callable<String>)() -> {System.out.println("Hello Lambda!");return null;};
	    
	    MyInterface myIn = (aa) -> {System.out.println(aa);};
	    myIn.f();
	    Thread oldSchool = new Thread( new Runnable () {
	        public void run() {
	            System.out.println("This is from an anonymous class.");
	        }
	    } );
	    Thread gaoDuanDaQiShangDangCi = new Thread(() -> {
	        System.out.println("This is from an anonymous method (lambda exp).");
	    } );
	    oldSchool.start();
	    gaoDuanDaQiShangDangCi.start();
	    
	    System.out.println(fib(2));
	    
	    distinctPrimary("1", "2", "3", "4", "5", "6", "7");
	}
	static int fib(int n){
    	return n == 1 || n == 2 ? 1 : fib(n - 1) + fib(n - 2);
	}
	
	public static void distinctPrimary(String... numbers) {
        List<String> l = Arrays.asList(numbers);
        List<Integer> r = l.stream()
                .map(e -> new Integer(e))
                .filter(e -> Primes.isPrime(e))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctPrimary result is: " + r);
    }
	protected UnaryOperator<Integer> factorial = i -> i == 0 ? 1 : i * this.factorial.apply( i - 1 );
}

class Primes{
	static boolean isPrime(long checkNumber){
		if(checkNumber <=2 || (checkNumber & 1) == 0){
			return false;
		}
		for(int i = 2; i <= Math.sqrt(checkNumber); i ++){
			if(checkNumber % i == 0){
				return false;
			}
		}
		return true;
	}
}

@FunctionalInterface
interface MyInterface{
	void f(String s);
	default public void doSomeOtherWork(){
		System.out.println("DoSomeOtherWork implementation in the interface");
	}
	default public void f(){
		System.out.println("this is default f()");
	}
}

class MyClass implements MyInterface{
	public void f(String s) {
		
	}
}

@FunctionalInterface
interface MyInterface1{
	void f(String s);
	default public void doSomeOtherWork(){
		System.out.println("DoSomeOtherWork implementation in the interface");
	}
	default public void f(){
		System.out.println("this is default f()");
	}
}