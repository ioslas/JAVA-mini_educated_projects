import java.util.ArrayList;
import java.util.Random;

public class SquareMatrixBasics {
	// Basic (only-can-do-)square matrix tasks 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize rows and columns
		int rows=new Random().nextInt(10)+1;
		int cols=rows;
		Matrix matrix= new Matrix(rows,cols);
		
		// Read matrix
		matrix.CreateMatrix();
		/* This is to show this matrix is identity 
		    int[][] n = { {1,0,0},
		  				  {0,1,0},
		  				  {0,0,1}
		  				};
		  	matrix = new Matrix(n);
		  	
		  	This is to show this matrix is symmetric
		  	int[][] n1 = { {1,2,3},
		  				   {2,4,5},
		  				   {3,5,6}
		  				 };
		  	matrix = new Matrix(n1);
		*/
		
		// Print matrix
		System.out.println("Matrix ("+ matrix.getRows() +"x"+ matrix.getCols() +"):");
		matrix.printMatrix();
		
		// Symmetric Matrix
		if(matrix.isSymmetric())
			System.out.println("The matrix is symmetric");
		else
			System.out.println("The matrix is not symmetric");
		System.out.println();
		
		// Identity Matrix
		if(matrix.isIdentity())
			System.out.println("This matrix is identity matrix");
		else
			System.out.println("This matrix is not identity matrix");
		System.out.println();

		// Triangular Matrix
		// We use it for square matrices because it's more visually clear
		/* How it looks like
		   {1,4,3},				Upper:	{0,4,3}			Lower: {0,0,0}
		   {2,6,7},		->				{0,0,7}				   {2,0,0}
		   {8,5,9}						{0,0,0}				   {8,5,0}
		 */
		ArrayList<Matrix> triangularMatrix=matrix.UpperLowerTriangular();
		System.out.println("Upper Triangular of matrix: "); 
		triangularMatrix.get(0).printMatrix();
		System.out.println("Lower Triangular of matrix: "); 
		triangularMatrix.get(1).printMatrix();
	}
}

