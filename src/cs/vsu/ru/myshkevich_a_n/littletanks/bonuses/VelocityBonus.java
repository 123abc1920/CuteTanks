package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;

public class VelocityBonus extends Bonus {
	private int velocity;
	private Random r = new Random();

	public VelocityBonus(int row, int col) {
		this.setRow(row);
		this.setCol(col);

		this.velocity = r.nextInt(3) + 1;
	}

	@Override
	public void setEffect(Tank tank) {
		tank.setCoreVelocity(this.velocity);
	}

	@Override
	public Symbol drawSymbol() {
		String s = String.valueOf(Global.velocitySymbol).repeat(velocity);
		return new Symbol(s);
	}

}
