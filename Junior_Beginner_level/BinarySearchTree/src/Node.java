public class Node {
	int key;
	// BST tree must have only two children nodes left and right
	Node right,left;
	// Constructor
	public Node(int item) {
		key=item;
		right=left=null;
	}
}
