
public class Airplane implements Updatable, Comparable<Airplane>{

	private int fuel, type, waitTime;
	private String airliner;
	private String[] airliners = {"Boeing", "Airbus", "Convair", "Bombardier"};
	public Airplane(String c, int t) {	//default when full fuel
		new java.util.Random();
		airliner = c;
		type = t;
		fuel = ( (int) (Math.random() * 10) + 5 );	//random fuel from 5 to 15. Checked true
		waitTime = 0;
	}
	
	public Airplane() {		//Overloaded constructor when no name given. Randomize name
		new java.util.Random();
		airliner = airliners[ (int) (Math.random() * (airliners.length - 1))];
		type = (int)((Math.random() * 100) -1);
		fuel = ( (int) (Math.random() * 10) + 5 );	//random fuel from 5 to 15. Checked true
		waitTime = 0;
	}
	
	public void update() {
		fuel--;
		waitTime++;
	}
	
	//Compares fuel, returns a negative integer, zero, or a positive integer 
	//as this object is less than, equal to, or greater than the specified object.
	public int compareTo(Airplane other) {
		return (other.getFuel() - fuel);
	}
	
	public boolean willCrash() {
		return (fuel == 0);
	}
	
	public int getFuel() {
		return fuel;
	}
	
	public int getWait() {
		return waitTime;
	}
	
	public String toString() {
		String toReturn = "Name: " + airliner + Integer.toString(type) 
			+ "\tFuel: " + fuel + "\tTime Waited: " + waitTime;
		return toReturn;
	}
	
}
