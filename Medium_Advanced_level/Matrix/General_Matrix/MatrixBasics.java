import java.util.Random;

public class MatrixBasics {
	// Basic general matrix tasks
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize rows and columns
	    int rows=new Random().nextInt(10)+1;
	    int cols=new Random().nextInt(10)+1;
	    
	    //Read matrix
	    Matrix matrix=new Matrix(rows,cols);
	    matrix.CreateMatrix();
	    
	    // Print matrix
	    System.out.println("Original Matrix ("+ matrix.getRows() +"x"+ matrix.getCols() +"):");
	    matrix.printMatrix();
	    
	    // Transpose matrix
	    Matrix transposedMatrix=matrix.transpose();
	    System.out.println("Tranposed Matrix ("+ matrix.getCols() +"x"+ matrix.getRows() +"):");
	    transposedMatrix.printMatrix();
	    
	    // Find main and secondary diagonal sum
	    int[] diagSum=matrix.diagSum();
	    System.out.println("Main diagonal sum of Matrix = "+ diagSum[0]);
	    System.out.println("Secondary diagonal sum of Matrix = "+ diagSum[1]);
	    
	    // Print matrix in spiral order
	    /* Example: 
	       { [1, 2, 3],
 			 [4, 5, 6],
 			 [7, 8, 9] 
 		   }
 		   1 -> 2 -> 3 -> 6 -> 9 -> 8 -> 7 -> 4 -> 5
 		   
 		   In code: 
 		   1 -> 2 -> 3 ->
 		   6 -> 9 ->
 		   8 -> 7 ->
 		   4 ->
 		   5
	     */
	    System.out.println("\nMatrix's elements in spiral order:");
	    matrix.printSpiral();
	    
	    // Find sum of elements by row and column
	    int[] rowsum = new int[rows];
	    int[] colsum = new int[cols];
	    matrix.RowColumnSum(rowsum, colsum);
	    
	    // Each row
	    System.out.println("Sum of Matrix's elements each row: ");
	    for(int i=0;i<rows;i++) 
	       System.out.print(rowsum[i] +" ");
	    System.out.println();
	    // Each column
	    System.out.println("\nSum of Matrix's elements each column: ");
	    for(int i=0;i<cols;i++) 
	       System.out.print(colsum[i] +" ");	    
	
	    // Min & Max elements
	    System.out.println();
	    int[] MinMax=matrix.MinMax();
        System.out.println("\nMinimum element of Matrix = "+ MinMax[0]);
	    System.out.println("Maximum element of Matrix = "+ MinMax[1]);
	}
}
