import java.util.Random;

public class SquareMatrixOperations {
	// Operations only applicable on square matrices
	// Basic purpose: Inverse the matrix
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize rows and columns
		int rows=new Random().nextInt(10)+1;
		int cols=rows;
		Matrix matrix= new Matrix(rows,cols);
		
		// Read matrix
		matrix.CreateMatrix();
		/* int[][] data = { {2, 4, 6},
			    			{1, 3, 5},
			    			{0, 2, 4}
						  };
		   
		matrix = new Matrix(data);
		*/ 
		
		// Print matrix
		System.out.println("Matrix ("+ matrix.getRows() +"x"+ matrix.getCols() +"):");
		matrix.printMatrix();
		
		// Determinant of Matrix
		double det=matrix.det(matrix,rows);
		System.out.println("det= "+ det);
		
		// Adjoint of Matrix
		Matrix adj = new Matrix(rows,cols);
		matrix.adj(matrix, adj, rows);
		System.out.println("\nAdjoint of matrix ("+ adj.getRows() +"x"+ adj.getCols() +"):");
		adj.printMatrix();
		
		// Inverse Matrix
		float[][] inverse=new float[rows][cols];
		if(matrix.inverse(rows, inverse)) {
			System.out.println("Inverse matrix ("+ adj.getRows() +"x"+ adj.getCols() +"):");
			display(inverse,rows,cols);
		}
	}
	// Display Matrix
	static void display(float[][] inv,int r,int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
				// At least 3 decimals
				System.out.printf("%.3f ", inv[i][j]);
			System.out.println();
		}
	}
}
