//This class header ensures that elements of PriorityQueue can be compared AND updated
public class LinkedPriorityQueue<T extends Comparable<T> & Updatable>{
	
	private Node<T> head, tail;
	private int numItems;
	
	public LinkedPriorityQueue(){
		head = null;
		tail = null;
		numItems = 0;
	}
	
	//The planes should sort in the priority queue by placing those with the least amount of fuel at the front
	public void enqueue(T newE){
		  try {
			  Node<T> newEntry = new Node<>(newE);
			  //System.out.println("Adding " + newE.toString());
			  Node<T> iterator = head;
			  while(iterator != null) {
				  if(iterator.val.compareTo(newEntry.val) >= 0) {		//if iterator after newEntry
					  //System.out.println("Compare " + iterator.val + " with " + newEntry.val
					  //	+ "\nYou get " + iterator.val.compareTo(newEntry.val));
					  newEntry.next = iterator.next;
					  iterator.next = newEntry;
					  iterator = newEntry;			//wherever iterator stops is the insertion position.
					  break;
				  }
				  else
					  iterator = iterator.next;
			  }
			  if(head == null) {
				  head = newEntry;
			  }
			  //System.out.println("Set iterator to " + newEntry.val.toString());
			  numItems++;
		  }catch(IllegalArgumentException e) {
			  System.out.println(e.getMessage());
		  }
	}
  
	public T dequeue(){
		if(!isEmpty()){   //if possible to remove a Node
			T toReturn = head.val;
			head = head.next;
			numItems--;
	    
			return toReturn;
		} 
		
		else
			return null;
	 }
	  
	public boolean isEmpty(){
		return ( head == null ) && ( tail == null);
	}
  
	public T getFront() {
		return null;
	}
  
	public int getSize() {
		return numItems;
	}
  
	public void clear(){
		if(!isEmpty()) {
			head.next = null;
			tail.next = null;
		}
	}
	
	public void updateValues(){
		Node<T> iterator = head;
		while(iterator != null) {
			iterator.val.update();
			iterator = iterator.next;
		}
	}
	
	 public String toString() {
		String total = "QUEUE:\t";
		Node<T> n = head;
		while(n != null) {
			total += n.val + "\t";
			n = n.next;
		}
	  	return total;
	 }
}
