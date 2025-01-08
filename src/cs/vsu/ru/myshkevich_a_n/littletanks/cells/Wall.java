package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class Wall extends Cell {

	private class WallMap {
		String up = "#";
		String down = "#";
		String right = "#";
		String left = "#";
	}

	private WallMap map = new WallMap();

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
			return false;
		}
		Target target = core.getTarget().getOpposite();

		for (int i = 0; i < core.getStrong(); i++) {
			switch (target) {
			case TOP:
				if (this.map.up.equals("#")) {
					this.map.up = ".";
				} else if (this.map.left.equals("#")) {
					this.map.left = ".";
				} else if (this.map.down.equals("#")) {
					this.map.down = ".";
				} else if (this.map.right.equals("#")) {
					this.map.right = ".";
				}
				break;
			case BOTTOM:
				if (this.map.down.equals("#")) {
					this.map.down = ".";
				} else if (this.map.right.equals("#")) {
					this.map.right = ".";
				} else if (this.map.left.equals("#")) {
					this.map.left = ".";
				} else if (this.map.up.equals("#")) {
					this.map.up = ".";
				}
				break;
			case LEFT:
				if (this.map.left.equals("#")) {
					this.map.left = ".";
				} else if (this.map.down.equals("#")) {
					this.map.down = ".";
				} else if (this.map.up.equals("#")) {
					this.map.up = ".";
				} else if (this.map.right.equals("#")) {
					this.map.right = ".";
				}
				break;
			case RIGHT:
				if (this.map.up.equals("#")) {
					this.map.up = ".";
				} else if (this.map.right.equals("#")) {
					this.map.right = ".";
				} else if (this.map.left.equals("#")) {
					this.map.left = ".";
				} else if (this.map.down.equals("#")) {
					this.map.down = ".";
				}
				break;
			}
		}

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
		String s = this.map.left + this.map.up + this.map.down + this.map.right;
		return new Symbol(s);
	}

}
