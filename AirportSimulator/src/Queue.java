
//implementation of a queue using a singly linked list
public class Queue<T> {

  Node<T> head;  //head points at the first Node
  Node<T> tail;  //tail points at the last Node
  
  //initializes queue as empty
  public Queue(){
    head.next = null;
    tail.next = null;
  }
  
  //adds a Node to the end of the linked list
  public void enqueue(T newE){
    Node<T> newEntry = new Node<>(newE);
    
    tail.next.next = newEntry; //add to end
    tail.next = newEntry;
    if(isEmpty()){  //first entry to be added, must point head to first Node
      head.next = tail.next;
    }
  }
  
  public T dequeue(){
    if(!isEmpty()){   //if possible to remove a Node
      head.next = head.next.next;     //This SHOULD take care of a 1-Node queue by pointing
                                      //head.next = null. CHECK************* b/c might cause null.
    } 
    return null;
  }
  
  public boolean isEmpty(){
    return ( head.next == null);
  }
  
  public void clear(){
    if(!isEmpty()) {
    	head.next = null;
    	tail.next = null;
    }
  }
  
  
}
