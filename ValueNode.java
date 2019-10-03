
public class ValueNode {
	
	private int value;
	private int currentRow;
	private int currentColumn;
	private ValueNode nextRow;
	private ValueNode nextColumn;
	
	public ValueNode(int value, int column, int row) {
		this.value = value;
		this.currentColumn = column;
		this.currentRow = row;
	}
	public ValueNode (int val) {
		this.value = val;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int val) {
		this.value = val;
	}
	public ValueNode getNextRow() {
		return nextRow;
	}
	public void setNextRow(ValueNode node) {
		this.nextRow = node;
	}
	public ValueNode getNextColumn() {
		return nextColumn;
	}
	public void setNextColumn(ValueNode node) {
		this.nextColumn = node;
	}
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int row) {
		this.currentRow = row;
	}
	public int getCurrentColumn() {
		return currentColumn;
	}
	public void setCurrentColumn(int column) {
		this.currentColumn = column;
	}
}
