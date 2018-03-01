//Node is a public class because it is used by multiple classes (Apron, ___Queue)
public class Node<T> {

	T val;
	Node next;
	public Node(T v) {
		val = v;
	}
}
