
public class SparseMatrix {
	
	private int totalRows;
	private int totalColumns;
	private MatrixRow firstRow;
	private MatrixColumn firstColumn;
	
// creates new sparse matrix	
	public SparseMatrix(int numRows, int numColumns) {
		
		firstRow = new MatrixRow();
		firstColumn = new MatrixColumn();
		
		totalRows = numRows;
		totalColumns = numColumns;
		
		
		MatrixRow temp = firstRow;
		for (int i = 0; i < numRows; i++) {
			temp.setNextRow(new MatrixRow());
			temp = temp.getNextRow();
		}
		MatrixColumn curr = firstColumn;
		for (int i = 0; i < numColumns; i++) {
			curr.setNextColumn(new MatrixColumn());
			curr = curr.getNextColumn();
		}
	}
// inserts value into sparse matrix at specific location	
	public void insertAt(int row, int column, int value) {
		
		ValueNode node = new ValueNode(value, column, row);
		MatrixColumn tempCol = firstColumn;
		
		for (int i = 1; i < column; i++) {
			tempCol = tempCol.getNextColumn();
			
		}
		tempCol.insertValue(node);
		
		MatrixRow tempRow = firstRow;
		for (int i = 1; i < row; i++) {
			tempRow = tempRow.getNextRow();
		}
		tempRow.insertValue(node);
	}
// prints the sparse matrix
	public void print() {

		MatrixRow tempRow = firstRow;
		for (int i = 0; i < totalRows; i++) {
			ValueNode temp = tempRow.getFirstValueNode();
			ValueNode first = temp;
			int counter = 0;
			while (temp.getNextColumn() != null) {
				if (counter == 0) {
					if (first.getCurrentColumn() != 1) {
						int numZeros = first.getCurrentColumn() - 1;
						for (int j = 0; j < numZeros; j++) {
							System.out.print(0 + " ");
						}
					}
					System.out.print(first.getValue() + " ");
					
					if (first.getNextColumn().getCurrentColumn() - first.getCurrentColumn() > 1) {
						int numZeros = first.getNextColumn().getCurrentColumn() - first.getCurrentColumn() - 1;
						for (int z = 0; z < numZeros; z++) {
							System.out.print(0 + " ");
						}
					}
					
					temp = temp.getNextColumn();
				}
				else {
					System.out.print(temp.getValue() + " ");
					if (temp.getNextColumn().getCurrentColumn() - temp.getCurrentColumn() > 1) {
						int numZeros = temp.getNextColumn().getCurrentColumn() - temp.getCurrentColumn() - 1;
						for (int k = 0; k < numZeros; k++) {
							System.out.print(0 + " ");
						}
					}
					temp = temp.getNextColumn();
				}
				
				
				counter ++;
			}
			
			if (counter == 0) {
				int numZeros = temp.getCurrentColumn() - 1;
				for (int y = 0; y < numZeros; y++) {
					System.out.print(0 + " ");
				}
				
			}
			

			System.out.print(temp.getValue() + " ");
			if (totalColumns - temp.getCurrentColumn() > 0) {
				int numZeros = totalColumns - temp.getCurrentColumn();
				for (int q = 0; q < numZeros; q++) {
					System.out.print(0 + " ");
				}
			}
			
			System.out.println();
			tempRow = tempRow.getNextRow();
		}
		System.out.println();
	}
// gets value at a specific location in the sparse matrix	
	public int getAt(int row, int column) {
		
		MatrixRow tempRow = firstRow;
		ValueNode tempVal = tempRow.getFirstValueNode();
		for (int i = 1; i < row; i++) {
			tempRow = tempRow.getNextRow();
		}
		tempVal = tempRow.getFirstValueNode();
		
		while (tempVal != null) {
			if (tempVal.getCurrentColumn() == column) {
				return tempVal.getValue();
			}
			tempVal = tempVal.getNextColumn();
		}
		
		return 0;
		
	}
// creates the transpose of a matrix	
	public SparseMatrix transpose () {
		
		SparseMatrix transposedMatrix = new SparseMatrix(totalColumns, totalRows);
		
		MatrixRow tempRow = firstRow;
		for (int i = 1; i <= totalRows; i++) {
			ValueNode tempVal = tempRow.getFirstValueNode();
			while (tempVal != null) {
				transposedMatrix.insertAt(tempVal.getCurrentColumn(), i, getAt(i, tempVal.getCurrentColumn()));
				tempVal = tempVal.getNextColumn();
			}
			tempRow = tempRow.getNextRow();
		}
		return transposedMatrix;
	}
// creates the products matrix of two matrices
	public SparseMatrix product (SparseMatrix otherMatrix) {
		
		SparseMatrix productMatrix = new SparseMatrix(totalRows, otherMatrix.totalColumns);
		
		for (int i = 1; i <= this.totalRows; i++) {
			
			for (int j = 1; j <= otherMatrix.totalColumns; j++) {
				int total = 0;
				
				for (int k = 1; k <= otherMatrix.totalRows; k++) {
					total += this.getAt(i, k) * otherMatrix.getAt(k, j);
				}
				productMatrix.insertAt(i, j, total);
				
			}
			
		}
		return productMatrix;
	}
}
