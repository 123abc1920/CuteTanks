package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.Random;

public class Enemy extends Tank {
	public Enemy(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);

		this.setSymbolUp(Global.getUpEnemySymbol());
		this.setSymbolDown(Global.getDownEnemySymbol());
		this.setSymbolLeft(Global.getLeftEnemySymbol());
		this.setSymbolRight(Global.getRightEnemySymbol());
	}

	@Override
	public void move(char c) {
		this.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);
		this.setRow(this.getRow() + this.getTarget().changeRowsCols()[0]);
		this.setCol(this.getCol() + this.getTarget().changeRowsCols()[1]);
	}
}
