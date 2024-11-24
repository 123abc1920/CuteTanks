package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Spawner extends Cell implements Destroyable {
	private int lifes = 1;

	public Spawner() {
		this.setSymbol(Global.spawnerSymbol);
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
		System.out.println("You win");
		System.exit(0);
		return false;
	}

}
