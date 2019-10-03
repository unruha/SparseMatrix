import java.util.Scanner;

public class MatrixReader {

// reads information and puts it into a sparse matrix
	public SparseMatrix read() {
		
		Scanner scan = new Scanner(System.in);
		
		int numRows = scan.nextInt();
		
		int numColumns = scan.nextInt();
		
		String slashNHOlder = scan.nextLine();
		
		String[] rowsArray = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			rowsArray[i] = scan.nextLine();
		}
	
		int[][] pairsArray = new int[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				pairsArray[i][j] = 0;
			}
		}
		
		for (int i = 0; i < rowsArray.length; i++) {
			String[] rowItems = rowsArray[i].split(" ");
			for (int j = 0; j < rowItems.length; j++) {
				String[] pairs = rowItems[j].split(",");
				
				pairsArray[i][(Integer.parseInt(pairs[0])-1)] = Integer.parseInt(pairs[1]);
				
			}
		}
//		for (int i = 0; i < numRows; i++) {
//			System.out.println();
//			for(int j = 0; j < numColumns; j++) {
//				System.out.print(pairsArray[i][j]);
//				System.out.print(" ");
//			}
//		}
//		System.out.println();
//		System.out.println();
		
		SparseMatrix matrix = new SparseMatrix(numRows, numColumns);
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (pairsArray[i][j] != 0) {
					
					matrix.insertAt(i + 1, j + 1, pairsArray[i][j]);
				}
			}
		}
		return matrix;
	}
}