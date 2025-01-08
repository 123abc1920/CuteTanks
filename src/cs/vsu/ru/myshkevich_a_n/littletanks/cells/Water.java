package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Water extends Cell {

	private String[] waterSymbols = { "\u2248", "~", "\u2242", "\u223D", "\u2A73", "\u224B" };
	private Random rand = new Random();

	public Water() {
		this.setSymbol(Global.waterSymbol);
		this.setAvailable(false);
	}

	public Water(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.waterSymbol);
		this.setAvailable(false);
	}

	@Override
	public boolean getAvailable() {
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		String s = waterSymbols[rand.nextInt(waterSymbols.length)] + waterSymbols[rand.nextInt(waterSymbols.length)]
				+ waterSymbols[rand.nextInt(waterSymbols.length)] + waterSymbols[rand.nextInt(waterSymbols.length)];
		return new Symbol(s);
	}

}
