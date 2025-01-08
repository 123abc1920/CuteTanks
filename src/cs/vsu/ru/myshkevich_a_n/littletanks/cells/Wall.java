package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class Wall extends Cell {
	private String map = "####";

	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(4);
	}

	public Wall(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(4);
	}

	@Override
	public char getSymbol() {
		if (this.getLifes() <= 0) {
			return '.';
		}
		String s = Integer.toString(this.getLifes());
		return s.charAt(0);
	}

	@Override
	public boolean setDestroy(Core core) {
		if (this.getLifes() <= 0) {
			this.map = "";
			return false;
		}
		Target target = core.getTarget().getOpposite();
		this.setLifes(this.getLifes() - core.getStrong());
		return true;
	}

	@Override
	public boolean getAvailable() {
		if (this.getLifes() <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		return new Symbol("#".repeat(getLifes()));
	}

}
