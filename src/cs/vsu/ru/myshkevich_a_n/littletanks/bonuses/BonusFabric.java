package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class BonusFabric {

	public static Bonus createBonus(char c, int i, int j) {
		switch (c) {
		case Global.activeBombSymbol:
			return new ActiveBomb(i, j);
		case Global.armorSymbol:
			return new AddArmor(i, j);
		case Global.lifeSymbol:
			return new AddLifeBonus(i, j);
		case Global.velocitySymbol:
			return new AddVelocityBonus(i, j);
		default:
			return null;
		}
	}
}
