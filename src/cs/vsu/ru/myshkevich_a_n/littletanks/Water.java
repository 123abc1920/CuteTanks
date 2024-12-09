package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Water extends Cell {
	public Water() {
		this.setSymbol(Global.waterSymbol);
		this.setAvailable(false);
	}

	public Water(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.waterSymbol);
		this.setAvailable(false);
	}

	@Override
	public boolean getAvailable() {
		return false;
	}

}
