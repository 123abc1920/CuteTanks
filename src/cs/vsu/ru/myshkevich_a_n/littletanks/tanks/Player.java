package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Player extends Tank {

	public Player(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLife(3);
		this.setCoreVelocity(1);

		this.setSymbolUp(Global.getUpPlayerSymbol());
		this.setSymbolDown(Global.getDownPlayerSymbol());
		this.setSymbolLeft(Global.getLeftPlayerSymbol());
		this.setSymbolRight(Global.getRightPlayerSymbol());
	}

	@Override
	public boolean isEnemy() {
		return false;
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		if (getFromEnemy) {
			if (this.getArmor() > 0) {
				this.setArmor(this.getArmor() - 1);
				return true;
			}
			this.setLife(-1);
			if (this.getLife() <= 0) {
				this.isKilled = true;
			}
		}
		return true;
	}

	@Override
	public Symbol drawSymbol() {
		if (this.target == Target.TOP) {
			return new Symbol("nn++");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("++uu");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("+)+)");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("(+(+");
		}
		return new Symbol("    ");
	}
}
