package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Enemy extends Tank {
    private char symbolUp='^';
    private char symbolLeft='>';
    private char symbolRight='<';
    private char symbolDown='v';

    public Enemy(int row, int col, Target target) {
        this.setCol(col);
        this.setRow(row);
        this.setTarget(target);
        this.setSymbol('V');
    }
}
