import java.util.Random;

public class StaticMatrices {
	//This class is for matrix operations without calling Matrix class
	//using static class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize rows and columns
		int rows=new Random().nextInt(20)+1;
		//int cols=new Random().nextInt(20)+1;
		int cols = rows;
		int[][] matrix=new int[rows][cols]; 
		
		//Create matrix
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				matrix[i][j]=new Random().nextInt(100);
		
		//Print matrix
		System.out.println("Original Matrix ("+ rows +"x"+ cols +"):");
		for(int[] matr: matrix) {
			for(int mat: matr)
				System.out.print(mat +" ");
			System.out.println();
		}			
	}
}

