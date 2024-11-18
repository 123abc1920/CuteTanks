package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Cell {
    private int row, col;
    private char symbol;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setRowCol(int row, int col) {
        this.col = col;
        this.row = row;
    }
}
