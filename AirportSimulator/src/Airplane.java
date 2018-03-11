
public class Airplane implements Updatable{

	private int fuel, type, takeOffWait, landWait;
	private String company;

	public Airplane(String c, int t) {	//default when full fuel
		company = c;
		type = t;
		fuel = ( (int) (Math.random() * 10) + 5 );	//random fuel from 5 to 15. Checked true
		takeOffWait = landWait = 0;
	}
	
	public int planeWait(boolean takeOffOrLand) {
		//boolean takeoffOrLand is true if takeOff, false if Land
		if(takeOffOrLand) {
			takeOffWait++;
		}
		else {
			landWait++;
		}
		return fuel--;		//CHECK if returns AND permanently decrements
	}
	
	public void refuel() {
		fuel = 15;
	}
	public boolean willCrash() {
		return (fuel == 5);
	}
	
	public int getFuel() {
		return fuel;
	}
	
	public int getWait(boolean tOr) {
		if(tOr) {
			return takeOffWait;
		}
		return landWait;
	}
	
	public String toString() {
		return company + Integer.toString(type);
	}
	
	public void update() {
		
	}
}
