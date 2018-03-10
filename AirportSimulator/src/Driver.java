
public class Driver {
	public static void main(String[] args) {
		Queue<String> x = new Queue<>();
		x.enqueue("balls");
		System.out.println(x.dequeue() + "\n" + x.dequeue() + "\n" + x.dequeue());
	}
}
