package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Player extends Tank {

	public Player(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLife(3);

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
	public boolean setDestroy(boolean getFromEnemy) {
		if (!getFromEnemy) {
			this.setLife(this.getLife() - 1);
			if (this.getLife() <= 0) {
				this.isKilled = true;
			}
		}
		return true;
	}
}
