package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class StrongEnemy extends Enemy {

	public StrongEnemy(int row, int col, Target target) {
		super(row, col, target);

		this.setLife(1);
		this.setArmor(3);
		this.setCoreVelocity(1);
	}

	@Override
	public Symbol drawSymbol() {
		if (this.target == Target.TOP) {
			return new Symbol("^^\u25CF\u25CF");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("\u25CF\u25CFvv");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("\u25CF>\u25CF>");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("<\u25CF<\u25CF");
		}
		return new Symbol("");
	}
}
