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
	public boolean setDestroy(Core core) {
		System.out.println(this.getCol() + " " + this.getRow() + " " + this.getLifes());
		this.setLifes(this.getLifes() - 1);
		System.out.println(this.getCol() + " " + this.getRow() + " " + this.getLifes());
		core.setNotAvailable();
		this.setCore(null);
		return false;
	}

}
