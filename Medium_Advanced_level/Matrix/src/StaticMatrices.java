import java.util.Random;

public class StaticMatrices {
	/* This class is for matrix operations without calling Matrix class,
	   using static classes (methods) */
	// Initialize rows and columns and declared them static 
	// because they are gonna be needed to all (almost) below methods
	static int rows=new Random().nextInt(20)+1;
	//private int cols=new Random().nextInt(20)+1;
	static int cols = rows; // I'll use square matrices in order to make tasks that only square matrices can do 
	static int[][] matrix = new int[rows][cols]; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create and print matrix are top 2 basic tasks, so
		   I added them in main */
		// Create matrix
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				matrix[i][j]=new Random().nextInt(100);
		
		// Print matrix
		System.out.println("Original Matrix ("+ rows +"x"+ cols +"):");
		for(int[] matr: matrix) {
			for(int mat: matr)
				System.out.print(mat +" ");
			System.out.println();
		}
		// Transpose Matrix
		int[][] transposedM = transposeMatrix();
		//Print Matrix
		System.out.println("\nTransposed Matrix ("+ rows +"x"+ cols +"):");
		display(transposedM);
		
		// Find & Print diagonal sum
		System.out.println();
		diagSum(rows,cols,matrix);

		// Check if the matrix is symmetric & identity
		/* matrix = new int[][]{ {1,0,0},
		  			    		 {0,1,0},
		  			    		 {0,0,1}
					  		   };
		   rows=cols=3;
		   display(matrix);
		*/	 
		
		// Check if the matrix is symmetric
		System.out.println();
		if(isSymmetric())
			System.out.println("The matrix is symmetric");
		else
			System.out.println("The matrix is not symmetric");
		System.out.println();
		
		// Check if the matrix is identity
		if(isIdentity())
			System.out.println("The matrix is identity");
		else
			System.out.println("The matrix is not identity");
		
		// Find Triangular Matrix (upper & lower)
		System.out.println();
		UpperLowerTriangular();
		
		// Find sum of elements by row and column
	    int[] rowsum = new int[rows];
	    int[] colsum = new int[cols];
	    RowColumnSum(rowsum, colsum);
	    
	    // Print the sums
	    // Each row
	    System.out.println("Sum of Matrix's elements each row: ");
	    for(int i=0;i<rows;i++) 
	       System.out.print(rowsum[i] +" ");
	    System.out.println();
	    // Each column
	    System.out.println("\nSum of Matrix's elements each column: ");
	    for(int i=0;i<cols;i++) 
	       System.out.print(colsum[i] +" ");
	    System.out.println();
	    
	    // Find min & max element
	    MinMax();
	    
	    // Matrix's elements in spiral order
	    System.out.println("\nMatrix's elements in spiral order:");
	    printSpiral();
	    
	    // Rotate Matrix
	    int[][] rotated;
	    // Appropriate degrees rotation is: 90, 180, 270
	    // clocks=0 || clocks=360 -> matrix is the same
	    for(int clocks=90; clocks<360; clocks+=90) {
		    rotated=rotate(clocks);
		    System.out.println("Matrix ("+ cols +"x"+ rows +") rotated in "+ clocks +" degrees is: ");
		    display(rotated);
		    System.out.println();
	    }
	}
	// Print the non-original matrices
	static void display(int[][] matr) {
	  for(int i=0;i<matr.length;i++) {
		for(int j=0;j<matr[i].length;j++)
			System.out.print(matr[i][j] +" ");
			System.out.println();
		}
	}
	static int[][] transposeMatrix() {
      int[][] transposedMatrix=new int[cols][rows];
      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            transposedMatrix[j][i]=matrix[i][j];
      
      return transposedMatrix;
	}
	static void diagSum(int r, int c, int[][] matr) {
	    int[] diagSum=new int[2];

	    for(int i=0;i<r;i++) 
	       for(int j=0;j<c;j++) {
	    	   // main diagonal sum
	    	   if(i==j) 
	             diagSum[0]+=matr[i][j];
	        	
	    	   // secondary diagonal sum
	           if (i+j == c-1) 
	             diagSum[1]+=matr[i][j];
	       }

		System.out.println("Main diagonal sum of Matrix = "+ diagSum[0]);
		System.out.println("Secondary diagonal sum of Matrix = "+ diagSum[1]);
	}
	static boolean isSymmetric() {
	   for(int i=0;i<rows;i++) 
	     for(int j=0;j<cols;j++) 
	       if (matrix[i][j]!=matrix[j][i]) 
	          return false;
	   return true;
	}
	static boolean isIdentity() {
	  for(int i=0;i<rows;i++) 
	     for(int j=0;j<cols;j++) {
	       if(i==j && matrix[i][j]!=1) 
	         return false;   
	       
	       if(i!= j && matrix[i][j]!=0) 
	         return false;
	     }
	  
	  return true;
	}
    static void UpperLowerTriangular() {
      int[][] upMatrix=new int[rows][cols];
      int[][] lowMatrix=new int[rows][cols];

      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) 
            if(i<j) {
              upMatrix[i][j]=matrix[i][j];
              lowMatrix[i][j]=0;
            }else if(i>j) {
              upMatrix[i][j]=0;
              lowMatrix[i][j]=matrix[i][j];
            }else 
              upMatrix[i][j] = lowMatrix[i][j] = 0;

      // Print Upper Triangular Matrix
      System.out.println("Upper Triangular of matrix:");
      display(upMatrix);
      System.out.println();
  	  // Print Lower Triangular Matrix
      System.out.println("Lower Triangular of matrix:");
      display(lowMatrix);
      System.out.println();
    }
    static void RowColumnSum(int[] rowsum, int[] colsum) {
	  int i,j;
	  // By row
	  for(i=0;i<rows;i++) {
         rowsum[i] = 0;
         for(j=0;j<cols;j++)
            rowsum[i]+=matrix[i][j];
      }
	  // By column
      for(j=0;j<cols;j++) {
         colsum[j]=0;
         for(i=0;i<rows;i++)
            colsum[j]+=matrix[i][j];
      }
   }
   static void MinMax() {
      int min=101;
      int max=0;

      for(int i=0;i<rows;i++) 
         for(int j=0;j<cols;j++) { 
            if(matrix[i][j]>max) 
              max=matrix[i][j];
            
            if(matrix[i][j]<min) 
               min=matrix[i][j];
         }
      
      // Print Min & Max element
      System.out.println("\nMinimum element of Matrix = "+ min);
	  System.out.println("Maximum element of Matrix = "+ max);
   }
   static void printSpiral() {
      int top=0, left=0;
      int bottom=rows-1, right=cols-1;
      if(cols==1 && rows==1) { // 1x1
         System.out.println(matrix[0][0]);
      }else {
        if(rows==1) { // 1xn
          for(int i=0;i<cols;i++) 
             System.out.print(matrix[0][i] +" ");
           System.out.println();
        }else if(cols==1) { // nx1
          for(int i=0;i<rows;i++) 
             System.out.print(matrix[i][0] +" ");
          System.out.println();
        }else // nxn
          while(top<=bottom && left<=right) { // Bounds for avoiding over-traversing
            // Due to many iterations, I isolate it in order not to declare its type again and again
            int i; 
            // Traverse 
            // left -> right topmost row
            for(i=left;i<=right;i++)
               System.out.print(matrix[top][i] +" ");
             top++;
             System.out.println();
            
             // up -> down rightmost column
             for(i=top;i<=bottom;i++) 
               System.out.print(matrix[i][right] +" ");
             right--;
             System.out.println();
            
             // right -> left bottom-most row
             if(top<=bottom) {
                for(i=right;i>=left;i--) 
                   System.out.print(matrix[bottom][i] +" ");
                bottom--;
                System.out.println();
             }
            
             // down -> up leftmost column
             if(left <= right) {
               for(i=bottom;i>=top;i--) 
                 System.out.print(matrix[i][left] +" ");
                 left++;
               System.out.println();
             }
          }
      }
   }
   static int[][] rotate(int clocks) {
      int[][] temp;
      int i,j;
      if(clocks==90) { // Rotate 90 degrees
         temp=new int[cols][rows];
         for(i=0;i<rows;i++) 
           for(j=0;j<cols;j++) 
              temp[j][rows-1-i]=matrix[i][j];
      }else if(clocks==180) { // Rotate 180 degrees
         temp=new int[rows][cols];
         for(i=0;i<rows;i++) 
           for(j=0;j<cols;j++) 
              temp[rows-1-i][cols-1-j]=matrix[i][j];
      }else { // Rotate 270 degrees
         temp=new int[cols][rows];
         for(i=0;i<rows;i++) 
            for(j=0;j<cols;j++) 
               temp[cols-1-j][i]=matrix[i][j];
      }
      return temp;
   }
}

