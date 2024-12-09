package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

public abstract class Bonus {
	private int row, col;

	public Bonus() {

	}

	public Bonus(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public void setEffect() {
		
	}
}
