package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell {
	public Wall() {
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
		this.setCore(null);
		if (this.getLifes() == 0) {
			Empty e = new Empty();
			e.setCol(this.getCol());
			e.setRow(this.getRow());
			return e;
		}
		return this;
	}

}
