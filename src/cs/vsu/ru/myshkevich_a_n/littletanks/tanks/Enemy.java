package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Enemy extends Tank {
	public Enemy(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLife(1);

		this.setSymbolUp(Global.getUpEnemySymbol());
		this.setSymbolDown(Global.getDownEnemySymbol());
		this.setSymbolLeft(Global.getLeftEnemySymbol());
		this.setSymbolRight(Global.getRightEnemySymbol());
	}

	@Override
	public boolean isEnemy() {
		return true;
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		if (getFromEnemy) {
			this.setLife(this.getLife() - 1);
			if (this.getLife() <= 0) {
				this.isKilled = true;
			}
		}
		return true;
	}
}
