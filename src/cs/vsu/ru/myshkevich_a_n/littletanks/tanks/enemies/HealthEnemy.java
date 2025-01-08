package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class HealthEnemy extends Enemy {

	public HealthEnemy(int row, int col, Target target) {
		super(row, col, target);

		this.setLife(4);
		this.setArmor(0);
		this.setCoreVelocity(1);
	}

	@Override
	public Symbol drawSymbol() {
		String s = "";
		if (this.target == Target.TOP) {
			s = "^^\u229D\u229D";
		}
		if (this.target == Target.BOTTOM) {
			s = "\u229D\u229Dvv";
		}
		if (this.target == Target.RIGHT) {
			s = "\u229D>\u229D>";
		}
		if (this.target == Target.LEFT) {
			s = "<\u229D<\u229D";
		}
		return new Symbol(s);
	}
}
