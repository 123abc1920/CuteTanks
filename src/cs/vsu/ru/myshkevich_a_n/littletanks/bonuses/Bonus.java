package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;

public abstract class Bonus {
	private int row, col;
	private char symbol;

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public abstract void setEffect(Tank tank);

	public abstract Symbol drawSymbol();
}
