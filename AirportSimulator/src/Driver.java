
public class Driver {
	public static void main(String[] args) {
		ControlTower x = new ControlTower();
		x.start(25, 500);
		System.out.println("All numbers in arbitrary time unit.\nTotal time: " + x.getTotalTime()
				+ "\n1. Average Takeoff Wait: " + x.getAverageTakeoffWait()
				+ "\n2. Max Takeoff Wait: " + x.getMaxTakeoffWait()
				+ "\n3. Average Landing Wait: " + x.getAverageLandingWait()
				+ "\n4. Max Landing Wait: " + x.getMaxLandingWait() 
				
				+ "\nTotal Planes: " + x.getTotalPlanes()
				+ "\n5. Total Crashed: " + x.getTotalCrash()
				+ "\n6b. Total Taken Off: " + x.getTotalTakenOff()
				+ "\n6a. Total Landed: " + x.getTotalLanded());
	}
}
