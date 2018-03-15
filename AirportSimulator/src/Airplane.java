
public class Airplane implements Updatable, Comparable<Airplane>{

	private int fuel, type, waitTime;
	private String airliner;
	private String[] airliners = {"Boeing", "Airbus", "Convair", "Bombardier"};

	public Airplane() {		//Randomized name
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
		return (fuel - other.getFuel());
	}
	
	public boolean willCrash() {
		return (fuel <= 0);
	}
	
	public int getFuel() {
		return fuel;
	}
	
	public int getWait() {
		return waitTime;
	}
	
	public String toString() {
		String toReturn = "Name: " + airliner + Integer.toString(type)
			+ " Fuel: " + fuel + " Time Waited: " + waitTime + "\n";
		return toReturn;
	}
	
}
