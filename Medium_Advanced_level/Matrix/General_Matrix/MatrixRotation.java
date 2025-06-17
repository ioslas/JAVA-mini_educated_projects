import java.util.*;

public class MatrixRotation {
	// This class handles matrix rotation operations.
	// It is separated from the other tasks because rotation produces different results depending on the angle (see below)
    public static void main(String[] args) {
	  // A task about rotating the Matrix
      Scanner scan=new Scanner(System.in);
      // Initialize rows and columns
      int rows=5;//(new Random()).nextInt(10)+1;
      int cols=4;//(new Random()).nextInt(10)+1;
      
      // Read Matrix
      Matrix matrix=new Matrix(rows,cols);
      matrix.CreateMatrix();
      //Print Matrix
      System.out.println("Original Matrix ("+ matrix.getRows() +"x"+ matrix.getCols() +"):");
      matrix.printMatrix();
      
      // Rotate Matrix
      Character answer;
      do {
    	  System.out.print("Give rotation degree (until 360): ");
          int clocks;
	      // Appropriate degrees rotation is: 0, 90, 180, 270, 360
	      for(clocks=scan.nextInt(); clocks%90!=0 || clocks>360; clocks=scan.nextInt()) {
	         System.out.println("Invalid rotation degree.Try again!");
	         System.out.print("\nGive rotation degree (until 360): ");
	      }
	      if (clocks!=0 && clocks!=360) {
	         Matrix rotatedMatrix=matrix.rotate(clocks);
	         System.out.println("\nMatrix ("+ rotatedMatrix.getRows() +"x"+ rotatedMatrix.getCols() +") rotated in "+ clocks +" degrees is: ");
	         rotatedMatrix.printMatrix();
	      }else // Rotate 0 or 360 degrees
	         System.out.println("Matrix doesn't change/remains the same");
	      
	      do {
			System.out.print("\nDo you want to continue rotating(y/n)? ");
			answer = Character.toLowerCase(scan.next().charAt(0));
			if(answer!='y' && answer!='n')
				System.out.println("Invalid answer.Try again!");
	      }while(answer!='y' && answer!='n');
	      System.out.println();
      }while(answer!='n');
      
      System.out.println("End of rotation!");
      scan.close();
   }
}
