package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Player extends Tank {

	public Player(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);
		this.setLifes(3);

		this.setSymbolUp(Global.getUpPlayerSymbol());
		this.setSymbolDown(Global.getDownPlayerSymbol());
		this.setSymbolLeft(Global.getLeftPlayerSymbol());
		this.setSymbolRight(Global.getRightPlayerSymbol());
	}
}
