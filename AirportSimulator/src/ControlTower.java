
public class ControlTower {
	
	private Airplane runwayPlane;
	private LinkedPriorityQueue<Airplane> landingQueue;
	private Queue<Airplane> takeoffQueue;
	private int runway;	//if 0, runway is empty.
	//checks whether runway plane needs to be transferred after 
	//landing. True = landing, false = takeoff
	private boolean needsTransfer;	
	
	//These fields used only for statistics
	private Queue<Airplane> landingSuccessQueue;
	private Queue<Airplane> takeoffSuccessQueue;
	private Queue<Airplane> crashQueue;
	
	private int totalTime, maxLWait, maxTWait;
	private double avgLWait, avgTWait;
	
	public ControlTower() {
		landingQueue = new LinkedPriorityQueue<>();
		takeoffQueue = new Queue<>();
		
		runway = 0;
		needsTransfer = false;
		
		landingSuccessQueue = new Queue<>();
		takeoffSuccessQueue = new Queue<>();
		crashQueue = new Queue<>();
	
		totalTime = 0;
		maxLWait = maxTWait = 0;
		avgLWait = avgTWait = 0;
	}
	
	//this big bertha is gonna make time pass and take in/land/take off random planes
	//release the helper method floodgates
	
	/*
	 * Each time your loop iterates represents another moment in time. In each moment of time, you need to:
	 * 
	 * Decide if a plane should join the take-off queue
	 * Decide if a plane should join the landing priority queue
	 * 
	 * Planes should show randomly, on average of about one every 6 units of time. 
	 * Any plane joining the landing priority queue should have a random amount of 
	 * remaining fuel assigned to it. This should range from 5 to 15 time-units of 
	 * fuel left. Each unit of time, the amount of fuel left should decrement. If 
	 * a plane's fuel reaches 0, it crashes. The planes should sort in the priority 
	 * queue by placing those with the least amount of fuel at the front.
	 */
	public void iterate(){
		//FIRST, check if any planes crash
		checkStatus();
		
		//THEN, check if runway plane succeeded in landing. If so, transfer to takeoffQueue.
		//Don't care about successful takeoff because they're going wherever they're going.
		if(runway == 0 && !runwayPlane.willCrash() && needsTransfer == true) {
			takeoffQueue.enqueue(runwayPlane);
			runwayPlane = null;
		}
		
		//THEN, add a plane to landing queue (by chance)
		Airplane newLanding = planeGenerator();
		if(newLanding != null) {	//if there was a plane inserted
			landingQueue.enqueue(newLanding);
		}
		
		//THEN, decrement
		decreaseFuels();
		
		//THEN, add plane if runway is empty
		if(runway == 0 && runwayPlane == null) {
			if(!landingQueue.isEmpty()) {
				runwayPlane = landingQueue.dequeue();
				runway = 2;
				needsTransfer = true;
			}
			else if (!takeoffQueue.isEmpty()) {
				runwayPlane = takeoffQueue.dequeue();
				runway = 3;
				needsTransfer = false;
			}
		}
		
		//and finally...
		totalTime++;
	}
	
	//finds any empty-fuel planes that never made it to the runway. These will always 
	//be at the front of the list b/c of priority, so checkStatus only deletes up to 
	//an Airplane with fuel > 0, then stops.
	//Also checks the current plane on the runway, which could crash if it doesn't have
	//enough fuel to cross the runway (3 or 2, depending on takeoff or landing)
	public void checkStatus() {
		while(landingQueue.getFront().willCrash() == false) {
			crashQueue.enqueue(landingQueue.dequeue());		//transfer crashed plane to crash record
		}
		if(runwayPlane != null && runwayPlane.willCrash()) {
			crashQueue.enqueue(runwayPlane);
			runwayPlane = null;
			runway = 0;
			//runway doesn't look like a word anymore :/
		}
	}
	
	public void decreaseFuels() {
		//decrement existing planes in the landing queue
		landingQueue.updateValues();
		//decrement currently landing plane and runway time, if there is a plane
		if(runwayPlane != null) {
			runwayPlane.update();
			runway--;
		}
	}
	
	//random airplane generator. Returns a random plane 17%, or once every 6th units of time.
	public Airplane planeGenerator() {
		new java.util.Random();
		if(randomize(17)) {	//return a plane 25% of the time
			return new Airplane();
		}
		return null;
	}
	
	//helper method that takes in percentage of something happening, returns t/f
	//based on randomized number
	public boolean randomize(int chance) {
		new java.util.Random();
		return ( (int) ( (Math.random() * chance) + 1) <= chance );
	}
	
	
	
	
	//METHODS HANDLING STATISTICS:
	//What is the average time spent waiting for take off?
	//What is the longest time spent waiting for take off?
	//What is the average time spent waiting to land?
	//What is the longest time spent waiting to land?
	//Did any planes crash?
	//How many planes total took off and landed during the simulation?
	
	public double getTotalTime() {
		return totalTime;
	}
	public double getAverageTakeoffWait() {
		return avgTWait;
	}
	
	public double getAverageLandingWait() {
		return avgLWait;
	}
	
	public double getMaxTakeoffWait() {
		return maxTWait;
	}
	
	public double getMaxLandingWait() {
		return maxLWait;
	}
	
	public int getTotalCrash() {
		return crashQueue.getSize();
	}
	
	public int getTotalTakenOff() {
		return takeoffSuccessQueue.getSize();
	}
	
	public int getTotalLanded() {
		return landingSuccessQueue.getSize();
	}
}
