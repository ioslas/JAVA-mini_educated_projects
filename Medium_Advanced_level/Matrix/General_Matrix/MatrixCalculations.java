import java.util.Random;
import java.util.Scanner;

public class MatrixCalculations {
	// Performs arithmetic operations (+, −, ×, ÷) on matrices.
   public static void main(String[] args) {
	   // TODO Auto-generated method stub
	   // Initialize rows and columns
	   int rows=new Random().nextInt(10)+1;
       int cols=new Random().nextInt(10)+1;
       
       // Create 2 matrices
       /* The dimensions is recommended to be equals because:
        * 1. Some operations (e.g. addition) can't work or at least there must be 
        * an equal dimension(like A: mXn, B: nXm) 
        * 2. To avoid complications and more complexities like in matrix multiplication: 
        * A*B: (mXn)*(nXm) = mXm  and
        * C[i][j] = A[i][k] * B[k][j] which means extra nested loop
        */
       Matrix matrix1=new Matrix(rows, cols);
       Matrix matrix2=new Matrix(rows, cols);
       matrix1.CreateMatrix();
       matrix2.CreateMatrix();
       /* You can use these matrices if you want more 
        * simple matrices for computations like
        * matrix1 / matrix2 -> matrix2 is invertible
        int[][] data1={ {2, 0, 1},
    		   		       {1, 3, 2},
    		   		       {0, 1, 1},
    		   		     };
          
        matrix1 = new Matrix(data1);
        
        int[][] data2={ {2, 0, 1},
        				{1, 2, 1},
        				{3, 4, 2}
    		   		  };
        matrix2 = new Matrix(data2);
       */ 
       // Print matrices
       System.out.println("Matrix 1 ("+ matrix1.getRows() +"x"+ matrix1.getCols() +"):");
       matrix1.printMatrix();
       System.out.println("Matrix 2 ("+ matrix2.getRows() +"x"+ matrix2.getCols() +"):");
       matrix2.printMatrix();
       
       Scanner scan=new Scanner(System.in);
       System.out.print("Give operation (+,-,*,/): ");
       String op=scan.nextLine();
       // Calculation (Operation) between matrices
       while(!op.equals("!")) {
    	  // Make the calculations
          Matrix OperatedMatrix=matrix1.calculate(matrix2, op);
          // Print Matrix
          if(OperatedMatrix!=null) {
            System.out.println("\nNew Matrix ("+ OperatedMatrix.getRows() +"x"+ OperatedMatrix.getCols() +"):");
            OperatedMatrix.printMatrix();
          }
          System.out.print("Give operation (+,-,*,/): ");
          op=scan.nextLine();
       }
       System.out.println("End of this operation.");   
       // Calculations (Operations) between matrix and number (scalar)
       System.out.print("\nWhat operation do you want to do with scalar (+,-,*,/): ");
       op=scan.nextLine();
       while(!op.equals("!")) {
    	   // Make the calculations
           Matrix OperatedMatrix=matrix1.calculate(op);
           // Print Matrix
           if(OperatedMatrix!=null) {
             System.out.println("\nNew Matrix ("+ OperatedMatrix.getCols() +"x"+ OperatedMatrix.getRows() +"):");
             OperatedMatrix.printMatrix();
           }
           System.out.print("What operation do you want to do with scalar (+,-,*,/): ");
           op=scan.nextLine();
       }
       
       System.out.println("\nEnd of operations.");
       scan.close();
   }
}
