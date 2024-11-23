package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Player extends Tank {

	public Player(int row, int col, Target target) {
		this.setCol(col);
		this.setRow(row);
		this.setTarget(target);

		this.setSymbolUp(Global.getUpPlayerSymbol());
		this.setSymbolDown(Global.getDownPlayerSymbol());
		this.setSymbolLeft(Global.getLeftPlayerSymbol());
		this.setSymbolRight(Global.getRightPlayerSymbol());
	}

	public void move(char c) {
		if (c == 'w') {
			this.setTarget(Target.TOP);
			this.setRow(this.getRow() - 1);
		}
		if (c == 's') {
			this.setTarget(Target.BOTTOM);
			this.setRow(this.getRow() + 1);
		}
		if (c == 'a') {
			this.setTarget(Target.LEFT);
			this.setCol(this.getCol() - 1);
		}
		if (c == 'd') {
			this.setTarget(Target.RIGHT);
			this.setCol(this.getCol() + 1);
		}
	}
}
