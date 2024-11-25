package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell {
	private int lifes = 3;

	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
	}

	@Override
	public char getSymbol() {
		String s = Integer.toString(this.lifes);
		return s.charAt(0);
	}

	@Override
	public boolean setDestroy(Core core) {
		this.setLifes(this.getLifes() - 1);
		core.setNotAvailable();
		this.setCore(null);
		return false;
	}

}
