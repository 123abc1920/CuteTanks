package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell {
	private int lifes = 3;

	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
	}

	public int getLifes() {
		return lifes;
	}

	public boolean setLifes(int lifes) {
		this.lifes = lifes;
		if (this.lifes == 0) {
			return false;
		}
		return true;
	}
}
