package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Flag extends Cell implements Destroyable {
	private int lifes = 1;

	public Flag() {
		this.setSymbol(Global.flagSymbol);
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
		System.out.println("You lose");
		System.exit(0);
		return false;
	}

}
