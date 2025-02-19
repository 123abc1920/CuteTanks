package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

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
	public boolean getAvailable() {
		return false;
	}

	@Override
	public boolean setDestroy(Core core) {
		if (!core.getFromEnemy()) {
			this.setLifes(this.getLifes() - core.getStrong());
			return true;
		}
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		return new Symbol("\u2691".repeat(4));
	}

}
