public class BST {
	Node root;
	// Constructor
	BST() {
		root=null;
	}
	// Insert key
	public void insert(int key) {
		root=insertRec(root,key);
	}
	Node insertRec(Node root, int key) {
		if(root==null) {
			// key becoming root
			root=new Node(key);
			return root;
		}
		/* In BST 
		 * left children's value < parent's value and 
		 * right children's value >= parent's value
		 */
		if(key<root.key)
			root.left=insertRec(root.left,key);
		else
			root.right=insertRec(root.right,key);
		
		return root;
	}
	// Print traversal order
	public void order(String ord) {
		orderRec(root,ord);
	}
	void orderRec(Node root,String order) {
		if(root!=null) {
			// in-order
			if(order=="in") {
				orderRec(root.left,order);
				System.out.print(root.key +" ");
				orderRec(root.right,order);
			// pre-order
			}else if(order=="pre") {
				System.out.print(root.key +" ");
				orderRec(root.left,order);
				orderRec(root.right,order);
			// post-order
			}else {
				orderRec(root.left,order);
				orderRec(root.right,order);
				System.out.print(root.key +" ");	
			}
		}
	}
	//Search key
	public boolean search(int key) {
		return searchRec(root,key);
	}
	boolean searchRec(Node root,int key) {
		// There is no root or the root is the key we are looking for 
		if(root==null || root.key==key) 
			return root!=null;
		
		// key <= root(parent): go left
		if(key<=root.key)
			return searchRec(root.left,key);
		
		// key > root(parent): go right
		return searchRec(root.right,key);
	}
	// Delete key
	public void delete(int key) {
		root=deleteRec(root,key);
	}
	Node deleteRec(Node root, int key) {
		if(root==null) return root;
		
		if(key<root.key)
			// Go left
			root.left=deleteRec(root.left,key);
		else if(key>root.key)
			// Go right
			root.right=deleteRec(root.right,key);
		else {
			// Case 1: Node is a leaf
			if(root.left==null && root.right==null)
				return null;
			 
			// Case 2: Node with only one child
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			
			// Case 3: Node with two children
			/* In-order successor: more common
			 * Find the small (min) key value of the right sub-tree &
			 * replace it to the deleted key value (root)  
			 */
			root.key=minValue(root.right);
			// delete the in-order successor
			root.right=deleteRec(root.right,root.key);
			
			/* In-order predecessor
			 * Find the big (max) key value of the left sub-tree &
			 * replace it to the deleted key value (root)  
		     
		     root.key=maxValue(root.left);
			 // delete the in-order predecessor
			 root.right=deleteRec(root.left,root.key);
			*/
		}
		return root;
	}
	// Find the small (min) value of this node
	private int minValue(Node r) {
		int minValue = r.key;
		while(r.left!=null) {
			minValue=r.left.key;
			r=r.left;
		}
		return minValue;	
	}
	/* Find the big (max) value of this node
	private int maxValue(Node r) {
		int maxValue=r.key;
		while(r.right!=null) {
			maxValue=r.right.key;
			r=r.right;
		}
		return maxValue;	
	} */
}
