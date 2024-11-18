package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CellFabric {
    private final List<AbstractCellFactory> factories = new ArrayList<>();

    public void addFactory(AbstractCellFactory tf) {
        factories.add(tf);
    }

    public Cell getCell(int x) {
        if (factories.size() == 0)
            return null;
        return factories.get(x).create();
    }
}
