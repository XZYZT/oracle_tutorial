package oracle.javase.tutorial.collections.interfaces.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Countdown {
	public static void main(String[] args) throws InterruptedException {
		if(args.length == 0){
			args = new String[]{"10"};
		}
		
		int time = Integer.parseInt(args[0]);
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		Random random = new Random();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = time; i > 0; i --){
			int randomNum = random.nextInt(i);
			queue.add(i);
			queue2.add(randomNum);
			list.add(randomNum);
			
		}
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
		System.out.println("queue2:" + queue2);
		System.out.println("list:" + list);
		
		System.out.println(list.containsAll(list));
		
		System.out.println(heapSort(list));
	}
	
	static <E> List<E> heapSort(Collection<E> c){
		Queue<E> queue = new PriorityQueue<E>(c);
		
		List<E> result = new ArrayList<E>();
		
		while(!queue.isEmpty()){
			result.add(queue.remove());
		}
		return result;
	}
}
