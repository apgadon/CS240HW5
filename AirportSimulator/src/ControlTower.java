
public class ControlTower {
	private LinkedPriorityQueue<Airplane> landingQueue;
	private Queue<Airplane> takeoffQueue;
	private Queue<Airplane> landingSuccessQueue;
	private Queue<Airplane> takeoffSuccessQueue;
	private Queue<Airplane> crashQueue;
	
	private int totalTime;
	
	public ControlTower() {
		landingQueue = new LinkedPriorityQueue<>();
		takeoffQueue = new Queue<>();
		landingSuccessQueue = new Queue<>();
		takeoffSuccessQueue = new Queue<>();
		crashQueue = new Queue<>();
	
		totalTime = 0;
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
		Airplane newLanding = planeGenerator();
		if(newLanding != null) {	//if there was a plane inserted
			landingQueue.enqueue(newLanding);
		}
		
		//and finally
		totalTime++;
	}
	
	//random airplane generator. Returns a random plane 17%, or once every 6th units of time.
	public Airplane planeGenerator() {
		new java.util.Random();
		if(randomize(17)) {	//return a plane 25% of the time
			return new Airplane();
		}
		return null;
	}

	
	//helper method that takes in percentage of somethign happening, returns t/f
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
	
	public double averageTakeoffWait() {
		return 0;
	}
	
	public double averageLandingWait() {
		return 0;
	}
	
	public double maxTakeoffWait() {
		return 0;
	}
	
	public double maxLandingWait() {
		return 0;
	}
	
	public int totalCrash() {
		return crashQueue.getSize();
	}
	
	public int totalTakenOff() {
		return takeoffSuccessQueue.getSize();
	}
	
	public int totalLanded() {
		return landingSuccessQueue.getSize();
	}
}
