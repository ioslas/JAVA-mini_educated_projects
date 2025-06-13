import java.util.*;

public class Matrix {
   private int[][] matr;
   private int rows,cols;
   int[][] sum,M;
   // Constructor with empty matrix
   public Matrix(int rows, int cols) {
      this.rows=rows;
      this.cols=cols;
      this.matr=new int[rows][cols];
   }
   // Constructor with data matrix
   public Matrix(int[][] data) {
      this.rows=data.length;
      this.cols=data[0].length;
      this.matr=data;
   }
   // Create Matrix
   public void CreateMatrix() {
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++)
            matr[i][j]=new Random().nextInt(10);
   }
   // Get Rows & Columns 
   public int getRows() {
      return rows;
   }
   public int getCols() {
      return cols;
   }
   // Convert Matrix to Array(int[][])
   public int[][] toArray() {
      return matr;
   }
   // Print Matrix
   public void printMatrix() {
      for(int i=0;i<rows;i++) {
         for(int j=0;j<cols;j++) 
            System.out.print(matr[i][j] +" ");
         System.out.println();
      }
      System.out.println();
   }
   // Transpose Matrix
   public Matrix transpose() {
      int[][] transposedMatrix=new int[cols][rows];
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            transposedMatrix[j][i]=matr[i][j];
      
      return new Matrix(transposedMatrix);
   }
   // Check & Inverse Matrix
   public boolean inverse(int N, float[][] inv) {
      // Find matrix's adjoint and put the data in this table
	  int[][] adjoint=new int[N][N];
      adj(new Matrix(matr), new Matrix(adjoint), N);
      // if det==0 -> not inversed matrix
      int determinant=det(new Matrix(matr), N);
      if (determinant==0) {
         System.out.println("\nMatrix is not inversable");
         return false;
      }else
    	// inv(A) = adj(A)/det(A)
        for(int i=0;i<N;i++) 
           for(int j=0;j<N;j++)
              inv[i][j] = adjoint[i][j]/determinant;
      
      return true;
   }
   // Find the determinant of Matrix
   public int det(Matrix mat, int n) {
	  int det=0;
      if(n==0) // Empty Matrix
        return 0;
      else if(n==1) // 1x1
        return mat.matr[0][0];
      else if(n==2) // 2x2
        return mat.matr[0][0]*mat.matr[1][1]-mat.matr[0][1]*mat.matr[1][0];
       
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
         det+= sign*mat.matr[0][i]*det(new Matrix(minor),n-1);
         sign= -sign;
      }
      return det;
   }
   // Find the adjoint of Matrix
   // The adjoint (adjugate) of a square matrix is the transpose of its cofactor matrix
   public void adj(Matrix mat, Matrix adj, int n) {
      if(n==1) // 1x1
        adj.matr[0][0]=1;
      else {
        int[][] temp=new int[n][n];
        int sign=0;

        for(int i=0;i<n;i++)
           for(int j=0;j<n;j++) {
              getCoFactor(mat,temp,i,j,n);
              sign = (i + j)%2==0 ? 1 : -1;
              adj.matr[j][i] = sign*det(new Matrix(temp), n-1);
           }
      }
   }
   // Get cofactor matrix by excluding row p and column q
   public static void getCoFactor(Matrix mat, int[][] minor, int p, int q, int n) {
      int i=0, j=0;
      for(int row=0;row<n;row++) 
         for(int col=0;col<n;col++) 
            if (row!=p && col!=q) {
               minor[i][j++]=mat.matr[row][col];
               if(j==n-1) {
                 j=0;
                 i++;
               }
            }
   }
   // Calculation between 2 matrices (addition, multiplication, etc.)
   /* Division is not applicable in Matrix but it can be done like:
    * A/B = A*B^(-1) 
    */
   public Matrix calculate(Matrix m, String op) {
      sum=new int[rows][cols];
      // Matrix will be calculated with its own self
      int[][] M=m.toArray();
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            if(op.equals("+")) // Addition
                sum[i][j]= matr[i][j] + M[i][j];
            else if(op.equals("-")) // Subtraction
                sum[i][j]= matr[i][j] - M[i][j];
            else if(op.equals("*")) // Multiplication
                sum[i][j]= matr[i][j] * M[i][j];
            else if (op.equals("/")) { // Division(sort of)
            	float[][] inv=new float[rows][cols];
                // Check if 2nd matrix is squared and invertible
            	if(m.rows==m.cols && m.inverse(m.rows,inv))
            		/* I made float -> int with round method because: 
            		 * 1. I can't cast sum matrix(table) from int -> float
            		 * 2. The matrix's class property about the table is int[][]
            		 *    so in "return new Matrix(as it shown below)" can't be float[][]
            		 */
            	    sum[i][j] = Math.round(matr[i][j]*inv[i][j]); 
                else { 
                	System.out.println("2nd Matrix not Squared/Invertible -> No Division!\n");
                	return null;
                }
            }else {
            	System.out.println("Null Operation. Try again later!\n");
            	return null;
            }
      return new Matrix(sum);
   }
   // Calculation between matrix and number (scalar)
   public Matrix calculate(String op) {
	   System.out.print("Give scalar: ");
       int scalar=new Scanner(System.in).nextInt();
	   for(int i=0;i<rows;i++) 
          for(int j=0;j<cols;j++)  
             if(op.equals("+")) // Addition
            	sum[i][j]= matr[i][j] + scalar;
             else if(op.equals("-")) // Subtraction
                sum[i][j]= matr[i][j] - scalar;
             else if(op.equals("*")) // Multiplication
                sum[i][j]= matr[i][j] * scalar;
             else if(op.equals("/")) { // Division
      	        if(scalar!=0) // Can't devide by zero
      		       sum[i][j]= Math.round(matr[i][j] / scalar);
      	        else {
      	           System.out.println("Unapropriate Number. No operation done!\n");
      	           return null;
      	        }
             }else {
            	 System.out.println("Null Operation. Try again later!\n");
            	 return null;
             }
	   
	   return new Matrix(sum);
	}
   //Find diagonal sum
   public int[] diagSum() {
      int[] diagSum=new int[2];

      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) {
        	// main diagonal sum
        	if(i==j) 
              diagSum[0]+=matr[i][j];
        	
        	// secondary diagonal sum
            if (i+j == cols-1) 
              diagSum[1]+=matr[i][j];
         }
      
      return diagSum;
   }
   // Check if the matrix is symmetric
   public boolean isSymmetric(Matrix trans) {
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            if (matr[i][j]!=matr[i][j]) 
               return false;
      return true;
   }
   // Check if the matrix is identity
   public boolean isIdentity() {
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) {
            if (i==j && matr[i][j]!=1) 
               return false;
            
            if (i!= j && matr[i][j]!=0) 
               return false;
         }
      
      return true;
   }
   // Rotate Matrix
   public Matrix rotate(int clocks) {
      int[][] temp;
      int i,j;
      // In 0 degrees
      if(clocks==90) { // Rotate 90 degrees
         temp=new int[cols][rows];
         for(i=0;i<rows;i++) 
           for(j=0;j<cols;j++) 
              temp[j][rows-1-i]=matr[i][j];
      }else if(clocks==180) { // Rotate 180 degrees
         temp=new int[rows][cols];
         for(i=0;i<rows;i++) 
           for(j=0;j<cols;j++) 
              temp[rows-1-i][cols-1-j]=matr[i][j];
      }else { // Rotate 270 degrees
         temp=new int[cols][rows];
         for(i=0;i<rows;i++) 
            for(j=0;j<cols;j++) 
               temp[cols-1-j][i]=matr[i][j];
      }
      return new Matrix(temp);
   }
   // Matrix elements in spiral order
   public void printSpiral() {
      int top=0, left=0;
      int bottom=rows-1, right=cols-1;
      if(cols==1 && rows==1) { // 1x1
         System.out.println(matr[0][0]);
      }else {
        if(rows==1) { // 1xn
          for(int i=0;i<cols;i++) 
             System.out.print(matr[0][i] +" ");
           System.out.println();
        }else if(cols==1) { // nx1
          for(int i=0;i<rows;i++) 
             System.out.print(matr[i][0] +" ");
          System.out.println();
        }else // nxn
          while(top<=bottom && left<=right) { // Bounds for avoiding over-traversing
            // Due to many iterations, I isolate it in order not to declare its type again and again
            int i; 
            // Traverse 
            // left -> right topmost row
            for(i=left;i<=right;i++)
               System.out.print(matr[top][i] +" ");
             top++;
             System.out.println();
            
             // up -> down rightmost column
             for(i=top;i<=bottom;i++) 
               System.out.print(matr[i][right] +" ");
             right--;
             System.out.println();
            
             // right -> left bottom-most row
             if(top<=bottom) {
                for(i=right;i>=left;i--) 
                   System.out.print(matr[bottom][i] +" ");
                bottom--;
                System.out.println();
             }
            
             // down -> up leftmost column
             if(left <= right) {
               for(i=bottom;i>=top;i--) 
                 System.out.print(matr[i][left] +" ");
                 left++;
               System.out.println();
             }
          }
      }
   }
   // Find Triangular Matrix (upper & lower)
   public ArrayList<Matrix> UpperLowerTriangular() {
      int[][] upMatrix=new int[rows][cols];
      int[][] lowMatrix=new int[rows][cols];
      ArrayList<Matrix> triangleMatrix=new ArrayList<Matrix>();

      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            if(i<j) {
              upMatrix[i][j]=matr[i][j];
              lowMatrix[i][j]=0;
            }else if(i>j) {
              upMatrix[i][j]=0;
              lowMatrix[i][j]=matr[i][j];
            }else 
              upMatrix[i][j] = lowMatrix[i][j] = 0;

      triangleMatrix.add(new Matrix(upMatrix));
      triangleMatrix.add(new Matrix(lowMatrix));
      return triangleMatrix;
   }
   // Sum each element by row & column
   public void RowColumnSum(int[] rowsum, int[] colsum) {
	  int i,j;
	  // By row
	  for(i=0;i<rows;i++) {
         rowsum[i] = 0;
         for(j=0;j<cols;j++)
            rowsum[i]+=matr[i][j];
      }
	  // By column
      for(j=0;j<cols;j++) {
         colsum[j]=0;
         for(i=0;i<rows;i++)
            colsum[j]+=matr[i][j];
      }
   }
   // Find min & max element
   public int[] MinMax() {
      int min=101;
      int max=0;
      int[] MinMax=new int[2];

      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) { 
            if(matr[i][j]>max) 
              max=matr[i][j];
            
            if(matr[i][j]<min) 
               min=matr[i][j];
         }
      
      MinMax[0] = min;
      MinMax[1] = max;
      return MinMax;
   }
}
