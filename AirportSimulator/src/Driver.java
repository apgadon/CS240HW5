
public class Driver {
	public static void main(String[] args) {
		ControlTower x = new ControlTower();
		x.start(100, 1000);
		System.out.println("---AIRPORT SIMULATOR TEST RESULTS---"
				+ "\nAll numbers in arbitrary time unit.\nTotal time: " + x.getTotalTime()
				+ "\nDEPARTURES:"
				+ "\n1.\tAverage Takeoff Wait: \t" + x.getAverageTakeoffWait()
				+ "\n2.\tMax Takeoff Wait: \t" + x.getMaxTakeoffWait()
				
				+ "\n\nLANDINGS"
				+ "\n3.\tAverage Landing Wait: \t" + x.getAverageLandingWait()
				+ "\n4.\tMax Landing Wait: \t" + x.getMaxLandingWait() 
				
				+ "\n\nPLANES:"
				+ "\n5.\tTotal Crashed: \t\t" + x.getTotalCrash()
				+ "\n6b.\tTotal Taken Off: \t" + x.getTotalTakenOff()
				+ "\n6a.\tTotal Landed: \t\t" + x.getTotalLanded());
	}
}
