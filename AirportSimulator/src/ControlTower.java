
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
	public void iterate(){
		
		
		//and finally
		totalTime++;
	}
	
	//random airplane generator. Returns a random plane 25% of the time.
	public Airplane planeGenerator() {
		new java.util.Random();
		if(Math.random() >= 0.25) {	//return a plane 25% of the time
			return new Airplane();
		}
		return null;
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
