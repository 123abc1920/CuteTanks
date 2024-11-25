package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Spawner extends Cell {

	public Spawner() {
		this.setSymbol(Global.spawnerSymbol);
		this.setLifes(1);
	}

	@Override
	public Cell setDestroy(Core core) {
		if (!core.getFromEnemy()) {
			this.setCore(null);
			this.setLifes(this.getLifes() - 1);
			core.setNotAvailable();
		}
		return this;
	}

}
