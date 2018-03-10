
//implementation of a queue using a singly linked list
public class Queue<T> {

  Node<T> head;  //head is EQUAL TO the first Node
  Node<T> tail;  //tail is EQUAL TO the last Node
  
  //initializes queue as empty
  public Queue(){
	  head = null;
	  tail = null;
  }
  
  //adds a Node to the end of the linked list
  public void enqueue(T newE){
	  Node<T> newEntry = new Node<>(newE);
	  if(tail != null)
		  tail.next = newEntry; //add to end
	  tail = newEntry;
	  if(isEmpty()) {
		  head = newEntry;
	  }
  }
  
  public T dequeue(){
	  if(!isEmpty()){   //if possible to remove a Node
    	T toReturn = head.val;
    	head = head.next;     //This SHOULD take care of a 1-Node queue by pointing
                                      //head.next = null. CHECK************* b/c might cause null.
    	return toReturn;
	  } 
	  else
		  return null;
  }
  
  public boolean isEmpty(){
	  return ( head == null);
  }
  
  public void clear(){
	  if(!isEmpty()) {
		  head.next = null;
		  tail.next = null;
	  }
  }
  
  
}
