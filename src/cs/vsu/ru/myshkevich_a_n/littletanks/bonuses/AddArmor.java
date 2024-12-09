package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Player;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;

public class AddArmor extends Bonus {
	private Random r = new Random();
	private int armorPoints;

	public AddArmor(int row, int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol(Global.armorSymbol);

		this.armorPoints = r.nextInt(4);
	}

	@Override
	public void setEffect(Tank tank) {
		tank.addArmor(this.armorPoints);
	}

}
