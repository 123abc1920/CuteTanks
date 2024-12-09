package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell {
	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(3);
	}

	public Wall(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(3);
	}

	@Override
	public char getSymbol() {
		String s = Integer.toString(this.getLifes());
		return s.charAt(0);
	}

	@Override
	public Cell setDestroy(Core core) {
		this.setLifes(this.getLifes() - 1);
		core.setNotAvailable();
		if (this.getLifes() == 0) {
			Empty e = new Empty();
			return e;
		}
		return this;
	}

}
