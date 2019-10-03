
public class MatrixRow {
	
	private MatrixRow nextRow;
	private ValueNode firstValueNode;
	
	public MatrixRow() {
		nextRow = null;
		firstValueNode = null;
	}
	
	public MatrixRow getNextRow() {
		return nextRow;
	}
	
	public void setNextRow(MatrixRow row) {
		nextRow = row;
	}
	
	public ValueNode getFirstValueNode() {
		return firstValueNode;
	}
// inserts value into specific row	
	public void insertValue(ValueNode value) {

		if (this.firstValueNode == null) {
			this.firstValueNode = value;
		}
		
		else if (value.getCurrentColumn() < firstValueNode.getCurrentColumn()) {
			ValueNode temp = firstValueNode;
			value.setNextColumn(temp);
			firstValueNode = value;
		}
		else {
			ValueNode temp = firstValueNode;
			while (temp.getNextColumn() != null && value.getCurrentColumn() > temp.getNextColumn().getCurrentColumn()) {
				temp = temp.getNextColumn();
			}
			if (temp.getNextColumn() == null) {
				temp.setNextColumn(value);
			}
			else {
				value.setNextColumn(temp.getNextColumn());
				temp.setNextColumn(value);
			}
		}
	}
	
}