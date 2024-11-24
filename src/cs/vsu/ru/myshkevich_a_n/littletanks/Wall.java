package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell {
	private int lifes;

	public Wall() {
		this.setSymbol(Global.wallSymbol);
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
}
