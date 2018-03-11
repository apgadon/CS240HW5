
public class Driver {
	public static void main(String[] args) {
		Queue<String> x = new Queue<>();
		x.enqueue("balls");
		x.enqueue("titties");
		x.enqueue("dickies");
		System.out.println(x.toString());
		
		System.out.println(x.dequeue());	//deques balls
		System.out.println(x.toString());
		System.out.println(x.dequeue());	//deques titties
		System.out.println(x.toString());
		System.out.println(x.dequeue());	//should be null at this point
		System.out.println(x.toString());
		
	}
}
