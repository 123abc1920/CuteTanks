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
			return new Symbol("^^##");
		}
		if (this.target == Target.BOTTOM) {
			return new Symbol("##vv");
		}
		if (this.target == Target.RIGHT) {
			return new Symbol("#>#>");
		}
		if (this.target == Target.LEFT) {
			return new Symbol("<#<#");
		}
		return new Symbol("");
    }
}
