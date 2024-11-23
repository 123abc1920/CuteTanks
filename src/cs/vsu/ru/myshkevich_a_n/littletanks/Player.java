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
		this.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);
		this.setRow(this.getRow() + this.getTarget().changeRowsCols()[0]);
		this.setCol(this.getCol() + this.getTarget().changeRowsCols()[1]);
	}
}
