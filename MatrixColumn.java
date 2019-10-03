
public class MatrixColumn {
	
	private MatrixColumn nextColumn;
	private ValueNode firstValueNode;
	
	public MatrixColumn() {
		nextColumn = null;
		firstValueNode = null;
	}
	
	public MatrixColumn getNextColumn() {
		return nextColumn;
	}
	
	public ValueNode getFirstValueNode() {
		return firstValueNode;
	}
	
	public void setNextColumn(MatrixColumn m) {
		nextColumn = m;
	}
// inserts value into specific column	
	public void insertValue(ValueNode value) {
		
		if (this.firstValueNode == null) {
			this.firstValueNode = value;
		}
		
		else if (value.getCurrentRow() < firstValueNode.getCurrentRow()) {
			ValueNode temp = firstValueNode;
			value.setNextRow(temp);
			firstValueNode = value;
		}
		else {
			ValueNode temp = firstValueNode;
			while (temp.getNextRow() != null && value.getCurrentRow() > temp.getNextRow().getCurrentRow()) {
				temp = temp.getNextRow();
			}
			if (temp.getNextRow() == null) {
				temp.setNextRow(value);
			}
			else {
				value.setNextRow(temp.getNextRow());
				temp.setNextRow(value);
			}
		}
		
	}
	
}
