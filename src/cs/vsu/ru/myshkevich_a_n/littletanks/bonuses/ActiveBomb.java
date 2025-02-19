package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;

public class ActiveBomb extends Bonus {
	private Random r = new Random();
	private int bombPoints;

	public ActiveBomb(int row, int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol(Global.activeBombSymbol);

		this.bombPoints = r.nextInt(3) + 1;
	}

	@Override
	public void setEffect(Tank tank) {
		tank.setLife(-bombPoints);
	}

	@Override
	public Symbol drawSymbol() {
		String s = "\u1F79".repeat(bombPoints);
		return new Symbol(s);
	}

}
