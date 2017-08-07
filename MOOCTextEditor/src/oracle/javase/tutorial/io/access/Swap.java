package oracle.javase.tutorial.io.access;

import java.util.Arrays;

public class Swap {
	static int[] arr = {0,1};
	static int a = 0, b = 1;
	public static void main(String[] args) {
		swap(arr,0 ,1);
		swapRawType(a, b);
		System.out.printf("a = %d, b = %d \n",a , b);
	}
	
	static void swap(int[] arr, int one, int two){
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
		System.out.println(Swap.arr == arr);
	}
	
	
	static void swapRawType(int a, int b){
		a = a ^ b ^ a;
		b = a ^ b ^ a;
		System.out.printf("a = %d, b = %d \n",a , b);
	}
}
