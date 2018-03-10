//Node is a public class because it is used by multiple classes
public class Node<T> {

	T val;
	Node<T> next;
	public Node(T v) {
		val = v;
	}
}
