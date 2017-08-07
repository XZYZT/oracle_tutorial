package oracle.javase.tutorial.classes.nested;

import java.util.Iterator;
import java.util.function.Function;

import javafx.scene.web.WebHistory;

public class DataStructure {
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];
	
	public DataStructure() {
		for(int i = 0; i < SIZE; i ++){
			this.arrayOfInts[i] = i;
		}
	}
	
	public void printEven(){
		DataStructureIterator iterator = this.new EvenIterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	interface DataStructureIterator extends Iterator<Integer>{}
	
	private class EvenIterator implements DataStructureIterator{
		private int nextIndex = 0;
		public boolean hasNext() {
			return (nextIndex <= SIZE - 1);
		}

		public Integer next() {
			Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
			nextIndex += 2;
			return retValue;
		}
	}
	
	public void print(DataStructureIterator iterator){
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public void print(Function<Integer,  Boolean> function){
		for(int i = 0; i < SIZE; i ++){
			if(function.apply(i)){
				System.out.print(arrayOfInts[i] + " ");
			}
		}
		System.out.println();
	}
	
	public static Boolean isEvenIndex(Integer index) {
    	if (index % 2 == 0) return Boolean.TRUE;
    	return Boolean.FALSE;
    }
	
	public static Boolean isOddIndex(Integer index) {
    	return !isEvenIndex(index);
    }
	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		ds.printEven();
		ds.print(new DataStructureIterator() {
			int i = -1;
			public Integer next() {
				i += 2;
				return ds.arrayOfInts[i];
			}
			
			public boolean hasNext() {
				return i < ds.SIZE - 2;
			}
		});
		
		ds.print((index) -> DataStructure.isEvenIndex(index)); 
		ds.print((index) -> !DataStructure.isEvenIndex(index)); 
		ds.print(DataStructure::isEvenIndex); 
	}
}
