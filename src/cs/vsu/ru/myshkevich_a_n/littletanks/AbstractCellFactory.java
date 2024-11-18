package cs.vsu.ru.myshkevich_a_n.littletanks;

public class AbstractCellFactory {
    Cell c;

    public AbstractCellFactory(Cell c) {
        this.c = c;
    }

    public Cell create() {
        return c;
    }
}
