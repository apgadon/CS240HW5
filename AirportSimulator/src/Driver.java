
import java.util.InputMismatchException;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		try{
			userInteraction();
		}catch(InputMismatchException e) {
			System.out.println("Invalid response");
		}

	}
	
	public static void userInteraction() throws InputMismatchException {
		Scanner scan = new Scanner(System.in);
		System.out.println("---AIRPORT SIMULATOR---\nPress 0 to input your own starting values."
				+ "\nPress 1 to start the simulator with default starting values.");
		int response = scan.nextInt();
		
		if(response == 0) {
			System.out.println("Number of starting planes: ");
			int sp = scan.nextInt();
			System.out.println("Number of time units (how many times the program iterates): ");
			int t = scan.nextInt();

			startProgram(sp, t);
		}
		else
			startProgram(100, 1000);
		
		System.out.println("Press 0 to start another simulation.\nPress 1 to quit.");
		int response2 = scan.nextInt();
		if(response2 == 0)
			userInteraction();
		scan.close();
	}
	
	public static void startProgram(int startingPlanes, int time) {
		ControlTower x = new ControlTower();
		x.start(startingPlanes, time);
		System.out.println("---AIRPORT SIMULATOR TEST RESULTS---"
				+ "\nAll numbers in an arbitrary time unit.\nTotal time: " + x.getTotalTime()
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
