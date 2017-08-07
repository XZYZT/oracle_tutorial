package my.utils;

import java.util.Arrays;

public class SortUtilsEperiment {
	public static void selectionSort(int[] vals) throws InterruptedException{
		System.out.println("selectionSort");
		int indexMin;
		for(int i = 0; i < vals.length - 1; i ++){
			indexMin = i;
			for(int j = i + 1; j < vals.length; j ++){//find the minimal number from unsorted part
				if(vals[j] < vals[indexMin]){
					indexMin = j;
				}
			}
			swap(vals, i, indexMin);
			System.out.println(Arrays.toString(vals));
		}
	}
	
	public static void insertionSort(int[] vals){
		System.out.println("insertionSort");
		int curIndex;
		for(int pos = 1; pos < vals.length; pos ++){
			curIndex = pos;
			while(curIndex > 0 && vals[curIndex] < vals[curIndex - 1] ){//comparison with the sorted part
				swap(vals, curIndex, curIndex - 1);
				curIndex --;
				System.out.println(Arrays.toString(vals));
			}
		}
	}
	
	public static void reversal(int[] vals){
		int valsLen = vals.length;
		for(int pos = 0; pos < valsLen/2; pos ++){
			swap(vals, pos, valsLen-pos-1);
		}
	}
	
	public static void swap(int[] vals, int index1, int index2){
		int temp = vals[index1];
		vals[index1] = vals[index2];
		vals[index2] = temp;
	}
	
	public static void main(String[] args) throws InterruptedException {
//		int[] vals = {1, 4, 5, 2, 8, 15, 11, 1};
		int[] vals = {1, 2, 3, 4, 5, 6, 7};
		selectionSort(vals);
		insertionSort(vals);
		reversal(vals);
		System.out.println("reversal :" + Arrays.toString(vals));
		selectionSort(vals);
		insertionSort(vals);
	}
}
