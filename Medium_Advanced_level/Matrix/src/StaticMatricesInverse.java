import java.util.Random;

public class StaticMatricesInverse {
	/* This class is for inverting the (square) matrix without calling Matrix class,
	   using static classes (methods) */
	// Initialize rows and columns and declared them static 
	// because they are gonna be needed to all (almost) below methods
	static int rows=new Random().nextInt(10)+1;
	// Only square matrices can be inversed 
	static int cols = rows;  
	static int[][] matrix = new int[rows][cols];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create and print matrix are top 2 basic tasks, so
		   I added them in main */
		// Create matrix
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				matrix[i][j]=new Random().nextInt(100);
		
		/* Non-invertible matrix
		*/matrix = new int[][]{ {2, 4, 6},
			 				   {1, 3, 5},
			 				   {0, 2, 4}
			  		   		};
		rows=cols=3;
		
		// Print matrix
		System.out.println("Original Matrix ("+ rows +"x"+ cols +"):");
		for(int[] matr: matrix) {
			for(int mat: matr)
				System.out.print(mat +" ");
			System.out.println();
		}
		// Check & Inverse Matrix
		float[][] inverse=new float[rows][cols];
		// I made private all the methods which are used inside the below method 
		// in order to make the code more modular and structured
		if(inverse(rows, inverse)) {
			// Print inversed matrix
			System.out.println("\nInverse matrix ("+ rows +"x"+ cols +"):");
			display(inverse);
		}
	}
	// Print the non-original matrices
	static void display(float[][] matr) {
	  for(int i=0;i<matr.length;i++) {
		for(int j=0;j<matr[i].length;j++)
			// At least 3 decimals
			System.out.printf("%.3f ", matr[i][j]);
		System.out.println();
	  }
	}
    static boolean inverse(int N, float[][] inv) {
      // Find matrix's adjoint and put the data in this table
	  int[][] adjoint=new int[N][N];
      adj(matrix, adjoint, N);
      // if det==0 -> not inversed matrix
      int determinant=det(matrix, N);
      if (determinant==0) {
         System.out.println("\nMatrix is not invertible");
         return false;
      }else
    	// inv(A) = adj(A)/det(A)
        for(int i=0;i<N;i++) 
           for(int j=0;j<N;j++)
              inv[i][j] = (float) adjoint[i][j]/determinant;
      
      return true;
    }
    // Find the determinant of Matrix
    private static int det(int[][] mat, int n) {
	  int det=0;
      if(n==0) // Empty Matrix
        return 0;
      else if(n==1) // 1x1
        return mat[0][0];
      else if(n==2) // 2x2
        return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0]; 
      // 3x3 and more
      /* det(A)= 
				i=0
			=	Σ ( (-1)^i * A[0,i] * det(M[0,i]) )
				n-1
		
		- A[0,i]: matrix row 0, column i
		- M[0,i]: is the minor matrix after removing row 0 and column 
		- (−1)^i: is the sign for that cofactor
      */ 
      int[][] minor=new int[n][n]; 
      int sign=1;
      
      for(int i=0;i<n;i++) {
     	 // Get cofactor matrix by excluding row 0 and column i
         getCoFactor(mat,minor,0,i,n);
         det+= sign*mat[0][i]*det(minor,n-1);
         sign= -sign;
      }
      return det;
    }
    // Find the adjoint of Matrix
    // The adjoint (adjugate) of a square matrix is the transpose of its cofactor matrix
    private static void adj(int[][] mat, int[][] adj, int n) {
      if(n==1) // 1x1
        adj[0][0]=1;
      else {
        int[][] temp=new int[n][n];
        int sign=0;

        for(int i=0;i<n;i++)
           for(int j=0;j<n;j++) {
              getCoFactor(mat,temp,i,j,n);
              sign = (i + j)%2==0 ? 1 : -1;
              adj[j][i] = sign*det(temp, n-1);
           }
      }
    }
    // Get cofactor matrix by excluding row p and column q
    private static void getCoFactor(int[][] mat, int[][] minor, int p, int q, int n) {
      int i=0, j=0;
      for(int row=0;row<n;row++) 
         for(int col=0;col<n;col++) 
            if (row!=p && col!=q) {
               minor[i][j++]=mat[row][col];
               if(j==n-1) {
                 j=0;
                 i++;
               }
            }
    }
}
