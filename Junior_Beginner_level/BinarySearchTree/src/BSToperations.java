import java.util.*;

public class BSToperations {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst=new BST();
		// Random size of tree
		int size = new Random().nextInt(20);
		// Create tree by inserting the key
		for(int i=0;i<size;i++) 	
			bst.insert(new Random().nextInt(100));
	
		//In order traversal is the most used/common
		System.out.println("In-order traversal of the BST:");
		bst.order("in");
		System.out.println();
		
		Character ans;
		Scanner scan=new Scanner(System.in);
		//Search and Delete together
		do {
			System.out.print("\nDelete from tree the number: ");
			int key=scan.nextInt();//new Random().nextInt(100);
			
			// Check if the key exists
			if(!bst.search(key))			
				System.out.println(key +" not found in tree");
			else {
				System.out.println(key +" found in tree");
				bst.delete(key);
				System.out.println(key +" is deleted");
				
				//Print new tree (order traversal)
				System.out.println("\nNew BST in in-order traversal ");
				bst.order("in");
				System.out.println();
			}
			
			System.out.print("Do you want to continue(y/n)? ");
			do {
				ans=scan.next().charAt(0);
				if(ans!='y' && ans!='n')
					System.out.print("\nWrong answer.Try again(y/n)? ");
			}while(ans!='y' && ans!='n');
		}while(ans!='n');
		
		//Other order traversal
		//Pre-order
		System.out.println("\nPre-order traversal of the BST:");
		bst.order("pre");
		System.out.println();
		//Post-order
		System.out.println("\nPost-order traversal of the BST:");
		bst.order("post");
		
		scan.close();
			
	}

}
