package oracle.javase.tutorial.classes;

public class Bicycle {
	private int cadence;//节奏
	private int gear;	//齿轮
	private int speed;
	private int id;
	private static int numberOfBicycles = 0;
	
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
        
        id = ++numberOfBicycles;
    }
    public int getID(){
    	return id;
    }
    
    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }
    
    public Bicycle() {
        gear = 1;
        cadence = 10;
        speed = 0;
    }
    public int getCadence() {
        return cadence;
    }
    
    public void setCadence(int newValue) {
        cadence = newValue;
    }
    
    public int getGear() {
        return gear;
    }
    
    public void setGear(int newValue) {
        gear = newValue;
    }
    
    public int getSpeed() {
        return speed;
    }
    /**
     * 刹车
     * @param decrement
     */
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
    /**
     * 加速
     * @param increment
     */
    public void speedUp(int increment) {
        speed += increment;
    }
    
}
