//Node is a public class because it is used by multiple classes (Apron, ___Queue)
public class Node {

	Airplane val;
	Node next;
	public Node(Airplane v) {
		val = v;
	}
}
