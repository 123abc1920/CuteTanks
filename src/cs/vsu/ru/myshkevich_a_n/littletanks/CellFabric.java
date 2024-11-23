package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellFabric {
	private class AbstractCellFactory {
		Cell c;

		public AbstractCellFactory(Cell c) {
			this.c = c;
		}

		public Cell create() {
			return c;
		}
	}

	private Map<Character, AbstractCellFactory> types = new HashMap<>();

	public CellFabric() {
		types.put(Global.waterSymbol, new AbstractCellFactory(new Water()));
		types.put(Global.treeSymbol, new AbstractCellFactory(new Tree()));
		types.put(Global.emptySymbol, new AbstractCellFactory(new Empty()));
		types.put(Global.wallSymbol, new AbstractCellFactory(new Wall()));
		types.put(Global.flagSymbol, new AbstractCellFactory(new Flag()));
		types.put(Global.spawnerSymbol, new AbstractCellFactory(new Spawner()));
	}

	public Cell getCell(char c) {
		return types.get(c).create();
	}

	public Cell createCell(char c) {
		switch (c) {
		case (Global.emptySymbol):
			return new Empty();
		case (Global.flagSymbol):
			return new Flag();
		case (Global.spawnerSymbol):
			return new Spawner();
		case (Global.wallSymbol):
			return new Wall();
		case (Global.waterSymbol):
			return new Water();
		case (Global.treeSymbol):
			return new Tree();
		}
		return null;
	}
}
