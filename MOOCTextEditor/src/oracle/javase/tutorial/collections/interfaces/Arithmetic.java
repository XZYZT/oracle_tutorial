package oracle.javase.tutorial.collections.interfaces;

/**
 * http://www.cnblogs.com/dandingyy/archive/2012/10/29/2745570.html
 * @author ShaQuan
 *
 */
public class Arithmetic{
	
	
	
	static int add(int a, int b){
		return b != 0 ? add(a^b, (a&b)<<1) : a;
	}
	
	static int addIter(int a, int b){
		int ans = 0;
		while(b == 1){
			ans = a ^ b;	//不计进位的和
			b = (a&b) << 1;	//进位
			a = ans;
		}
		return ans;
	}
	/**
	 * 正数补码
	 * @param a
	 * @return
	 */
	static int negative(int a){
		return add(~a, 1);
	}
	/**
	 * 是否负数
	 * @param a
	 * @return
	 */
	static int isNeg(int a){
		return a & 0x8000;
	}
	/**
	 * 减法
	 * @param a
	 * @param b
	 * @return
	 */
	static int minus(int a, int b){
		return add(a, negative(b));
	}
	/**
	 * 乘法（正数）
	 * @param a
	 * @param b
	 * @return
	 */
	static int multi(int a, int b){
		int multiNum = a;
		while(b != 1){
			b = minus(b, 1);
			a = add(multiNum, a);
		}
		
		return a;
	}
	
	static double pi(int precision){
		precision = precision < 5 ? 5 : precision;
		double a = - 1.0/3.0;
		for(double i = 5; i <= precision; i += 2){
			a += 1/i;
		}
		return 4.0 * (1.0 - a);
	}
	public static void main(String[] args) {
		System.out.println(pi(11));
		System.out.println(1.0/3.0 + 1.0/5.0 + 1.0/7.0);
	}
}
