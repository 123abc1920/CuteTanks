package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;

public class World {
    private Cell[][] board = new Cell[13][13];
    private List<Enemy> enemies = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Water> waters = new ArrayList<>();
    private List<Tree> trees = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();

    public World() {
        CellFabric cf = new CellFabric();
        cf.addFactory(new AbstractCellFactory(new Empty()));
        cf.addFactory(new AbstractCellFactory(new Tree()));
        cf.addFactory(new AbstractCellFactory(new Water()));
        cf.addFactory(new AbstractCellFactory(new Wall()));

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                this.board[i][j] = cf.getCell(i);
                this.board[i][j].setRowCol(i, j);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        this.board[row][col] = cell;
    }
}
