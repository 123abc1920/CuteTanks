package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Player extends Tank {
	private char playerNumber;

	public Player(int row, int col, Target target, char num) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLife(3);
		this.setCoreVelocity(1);
		this.playerNumber = num;

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
	public boolean setDestroy(Core core) {
		if (core.getFromEnemy()) {
			if (this.getArmor() > 0) {
				this.setArmor(this.getArmor() - core.getStrong());
				return true;
			}
			this.setLife(-core.getStrong());
			if (this.getLife() <= 0) {
				this.isKilled = true;
			}
		}
		return true;
	}

	@Override
	public Symbol drawSymbol() {
		if (this.target == Target.TOP) {
			return new Symbol("nn" + playerNumber + "\u2295");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("\u2295" + playerNumber + "u");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("\u2295)" + playerNumber + ")");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("(" + playerNumber + "(\u2295");
		}
		return new Symbol("");
	}
}
