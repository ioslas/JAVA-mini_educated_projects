import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
   public static void main(String[] args) {
	   // TODO Auto-generated method stub
	   // Initialize rows and columns
	   int rows=new Random().nextInt(20)+1;
       int cols=new Random().nextInt(20)+1;
       
       // Create 2 matrices
       Matrix matrix1=new Matrix(rows, cols);
       Matrix matrix2=new Matrix(rows, cols);
       matrix1.CreateMatrix();
       matrix2.CreateMatrix();
       /* You can use that (and to other matrix too) if you want more 
        * simple matrices for computations like
        * matrix1 / matrix2 -> matrix2 is invertible
          
        int[][] data={ { 1, 2 },
    		   		   { 3, 4 }
    		   		 };
        matrix2 = new Matrix(data);
       */
       // Print matrices
       System.out.println("Matrix 1 ("+ matrix1.getRows() +"x"+ matrix1.getCols() +"):");
       matrix1.printMatrix();
       System.out.println("Matrix 2 ("+ matrix2.getRows() +"x"+ matrix2.getCols() +"):");
       matrix2.printMatrix();
       
       Scanner scan=new Scanner(System.in);
       System.out.print("Give operation: ");
       String op=scan.nextLine();
       // Calculation (Operation) between matrices
       do {
    	  // Make the calculations
          Matrix OperatedMatrix=matrix1.calculate(matrix2, op);
          // Print Matrix
          if(OperatedMatrix!=null) {
            System.out.println("\nNew Matrix ("+ OperatedMatrix.getCols() +"x"+ OperatedMatrix.getRows() +"):");
            OperatedMatrix.printMatrix();
          }
          System.out.print("Give operation: ");
          op=scan.nextLine();
       }while(!op.equals("!"));
       
       // Calculations (Operations) between matrix and number (scalar)
       System.out.print("\nWhat operation do you want to do with scalar: ");
       op=scan.nextLine();
       do {
    	   // Make the calculations
           Matrix OperatedMatrix=matrix1.calculate(op);
           // Print Matrix
           if(OperatedMatrix!=null) {
             System.out.println("\nNew Matrix ("+ OperatedMatrix.getCols() +"x"+ OperatedMatrix.getRows() +"):");
             OperatedMatrix.printMatrix();
           }
           System.out.print("What operation do you want to do with scalar: ");
           op=scan.nextLine();
       }while(!op.equals("!"));
       
       System.out.print("End of operations.");
       scan.close();
   }
}
