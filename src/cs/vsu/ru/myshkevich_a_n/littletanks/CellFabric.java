package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellFabric {
	private Map<Character, AbstractCellFactory> types = new HashMap<>();

	public CellFabric() {
		types.put('~', new AbstractCellFactory(new Water()));
		types.put('@', new AbstractCellFactory(new Tree()));
		types.put('.', new AbstractCellFactory(new Empty()));
		types.put('#', new AbstractCellFactory(new Wall()));
		types.put('$', new AbstractCellFactory(new Flag()));
		types.put('X', new AbstractCellFactory(new Spawner()));
	}

	public Cell getCell(char c) {
		return types.get(c).create();
	}
}
