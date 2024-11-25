package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Flag extends Cell {

	public Flag() {
		this.setSymbol(Global.flagSymbol);
		this.setLifes(1);
	}

	@Override
	public Cell setDestroy(Core core) {
		if (core.getFromEnemy()) {
			this.setCore(null);
			this.setLifes(this.getLifes() - 1);
			core.setNotAvailable();
		}
		return this;
	}

}
