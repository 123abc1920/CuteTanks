package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class CellFabric {

	public static Cell createCell(char c, int i, int j) {
		switch (c) {
		case Global.wallSymbol:
			return new Wall(i, j);
		case Global.flagSymbol:
			return new Flag(i, j);
		case Global.spawnerSymbol:
			return new Spawner(i, j);
		case Global.treeSymbol:
			return new Tree(i, j);
		case Global.waterSymbol:
			return new Water(i, j);
		case Global.strongWallSymbol:
			return new StrongWall(i, j);
		default:
			return null;
		}
	}
}
