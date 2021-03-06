
//implementation of a queue using a singly linked list
public class Queue<T> {

  private Node<T> head;  //head is EQUAL TO the first Node
  private Node<T> tail;  //tail is EQUAL TO the last Node
  private int numItems;
  
  //initializes queue as empty
  public Queue(){
	  head = null;
	  tail = null;
  }
  
  //adds a Node to the end of the linked list
  public void enqueue(T newE){
	  try {
		  Node<T> newEntry = new Node<>(newE);
		  if(tail != null)
			  tail.next = newEntry; //add to end
		  if(isEmpty())
			  head = newEntry;		//if empty, set to head as well
		  
		  tail = newEntry;			//for both circumstances, tail set to new.
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
  
  public T getFront() {
	  if(!isEmpty())
		  return head.val;
	  return null;
  }
  public boolean isEmpty(){
	  return (numItems == 0);
  }
  
  public void clear(){
	  if(!isEmpty()) {
		  head.next = null;
		  tail.next = null;
	  }
  }
  
  public int getSize() {
	  return numItems;
  }
  
  public Node<T> clone() {
	  return head;
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
