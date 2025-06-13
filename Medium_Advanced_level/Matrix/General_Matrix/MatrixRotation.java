import java.util.*;

public class MatrixRotation {
   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      // Initialize rows and columns
      int rows=(new Random()).nextInt(10)+1;
      int cols=(new Random()).nextInt(10)+1;
      
      // Read Matrix
      Matrix matrix=new Matrix(rows,cols);
      matrix.CreateMatrix();
      //Print Matrix
      System.out.println("Original Matrix ("+ matrix.getRows() +"x"+ matrix.getCols() +"):");
      matrix.printMatrix();
      
      // Rotate Matrix
      System.out.print("Give rotation degree (until 360): ");
      int clocks;
      // Appropriate degrees rotation is: 0, 90, 180, 270, 360
      for(clocks=scan.nextInt(); clocks%90!=0 || clocks>360; clocks=scan.nextInt()) {
         System.out.println("Invalid rotation degree.Try again!");
         System.out.print("\nGive rotation degree (until 360): ");
      }
      if (clocks!=0 && clocks!=360) {
         Matrix rotatedMatrix=matrix.rotate(clocks);
         System.out.println("\nMatrix ("+ matrix.getCols() +"x"+ matrix.getRows() +") rotated in "+ clocks +" degrees is: ");
         rotatedMatrix.printMatrix();
      }else // Rotate 0 or 360 degrees
         System.out.println("Matrix doesn't change/remains the same");
      
      scan.close();
   }
}
