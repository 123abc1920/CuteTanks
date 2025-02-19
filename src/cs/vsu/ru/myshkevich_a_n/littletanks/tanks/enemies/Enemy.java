package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class Enemy extends Tank {
	public Enemy(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLife(1);
		this.setArmor(0);
		this.setCoreVelocity(1);
		this.setCoreStrong(1);

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
	public boolean setDestroy(Core core) {
		if (!core.getFromEnemy()) {
			if (this.getArmor() >= 0) {
				this.setArmor(this.getArmor() - core.getStrong());
				return true;
			}
			this.setLife(- core.getStrong());
			if (this.getLife() <= 0) {
				this.isKilled = true;
			}
		}
		return true;
	}

	@Override
	public Symbol drawSymbol() {
		if (this.target == Target.TOP) {
			return new Symbol("^^\u2297\u2297");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("\u2297\u2297vv");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("\u2297>\u2297>");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("<\u2297<\u2297");
		}
		return new Symbol("");
	}
}
