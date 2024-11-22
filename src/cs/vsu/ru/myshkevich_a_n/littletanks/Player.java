package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Player extends Tank {

    public Player(int row, int col, Target target) {
        this.setCol(col);
        this.setRow(row);
        this.setTarget(target);
        

		this.setSymbolUp('n');
		this.setSymbolDown('u');
		this.setSymbolLeft('(');
		this.setSymbolRight(')');
    }
}
