//"Apron" refers to where planes are parked between landing and takeoff.
//Class contains a regular queue of landed planes that iterates every 30 time units.
public class Apron {
	
	private Node top;
	private Node end;
	
	public Apron() {
		top.next = end;
	}
	
	public void add(Airplane a) {
		end.next = new Node(a);
		end = end.next;				//CHECK. Might cause error
	}
	
	public void leaveApron() {	//"deletes" first Node of the queue, effectively incrementing it
		top.val.refuel();		//refuels plane to 15 before taking off bc common sense
		top = top.next;
	}
}
