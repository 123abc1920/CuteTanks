package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class FastEnemy extends Enemy {

    public FastEnemy(int row, int col, Target target) {
        super(row, col, target);

        this.setLife(1);
        this.setArmor(0);
        this.setCoreVelocity(3);
    }
    
    @Override
    public Symbol drawSymbol() {
    	if (this.target == Target.TOP) {
			return new Symbol("^^oo");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("oovv");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("o>o>");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("<o<o");
		}
		return new Symbol("");
    }
}