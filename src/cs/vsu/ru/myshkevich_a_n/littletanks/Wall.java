package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Wall extends Cell implements Destroyable {
	private int lifes = 3;

	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	@Override
	public int getLife() {
		return this.lifes;
	}

	@Override
	public void setLife(int life) {
		this.lifes = life;
	}

	@Override
	public boolean setDestroy() {
		this.setLife(this.getLife() - 1);
		if (this.getLife() <= 0) {
			return true;
		}
		return false;
	}

}
