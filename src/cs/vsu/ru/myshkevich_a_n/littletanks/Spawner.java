package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Spawner extends Cell {

	public Spawner() {
		this.setSymbol(Global.spawnerSymbol);
		this.setLifes(1);
	}

	public Spawner(int row, int col) {
		this.setSymbol(Global.spawnerSymbol);
		this.setLifes(1);
		this.setCol(col);
		this.setRow(row);
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		if (!getFromEnemy) {
			this.setLifes(this.getLifes() - 1);
			return true;
		}
		return false;
	}

}
