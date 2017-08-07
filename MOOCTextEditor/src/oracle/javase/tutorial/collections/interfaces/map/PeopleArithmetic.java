package oracle.javase.tutorial.collections.interfaces.map;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
/**
 * 	1.Period
	2.Duration
	3.ChronoUnit
 * @author ShaQuan
 *
 */
public class PeopleArithmetic {
	public long daysToSeconds(int days){
		Instant instNow = Instant.now();
		Instant inst1 = instNow.plus(Duration.ofDays(days));
		return Duration.between(instNow, inst1).toMinutes() * 60;
	}
	
	private long population = 0;
	private long secondsGrow = 0;
	private long born;
	private long die;
	private long moveIn;
	public long  born(){
		return this.born;
	}
	
	public long die(){
		return this.die;
	}
	
	public long moveIn(){
		return this.moveIn;
	}
	
	public PeopleArithmetic(int days) {
		this.secondsGrow = daysToSeconds(days);
		this.born = secondsGrow/7;
		this.die = secondsGrow/13;
		this.moveIn = secondsGrow/45;
		population = population + born - die + moveIn;
	}
	
	public long getPopulation(){
		return population;
	}
	
	public static void main(String[] args) {
		PeopleArithmetic pa = new PeopleArithmetic(365);
		System.out.println(pa.getPopulation());
		
		System.out.println((double)System.currentTimeMillis()/1000/60/60/24/365);
		long bornDays = Duration.between(LocalDateTime.of(1992, 9, 8, 11, 11), LocalDateTime.now()).toDays();
		System.out.println(bornDays);
	}
}
