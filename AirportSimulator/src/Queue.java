
//implementation of a queue using a singly linked list
public class Queue<T> {

  Node head;  //head points at the first Node
  Node tail;  //tail points at the last Node
  
  //THIS NODE CLASS SHOULDN'T BE HERE. Delete as soon as this class correctly
  //communicates with the separate Node Generic class
  /*
  private class Node{
    T val;
    Node next;
    public Node(T v){
      val = v;
    }
  }
  */
  //initializes queue as empty
  public Queue(){
    //****************DO WE NEED THIS?
  }
  
  //adds a Node to the end of the linked list
  public void enqueue(T new){
    Node newEntry = new Node(new);
    
    tail.next = newEntry; //add to end
    if(isEmpty){  //first entry to be added, must point head to first Node
      head.next = tail.next;
    }
  }
  
  public T dequeue(){
    if(!isEmpty()){   //if possible to remove a Node
      head.next = head.next.next;     //This SHOULD take care of a 1-Node queue by pointing
                                      //head.next = null. CHECK************* b/c might cause null.
    } 
  }
  
  public boolean isEmpty(){
    return ( head.next == null);
  }
  
  public void clear(){
    while(head.next != null){
      head = head.next;
    }
  }
  
  
}
