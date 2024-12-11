package cs.vsu.ru.myshkevich_a_n.littletanks.bonuses;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;

public class AddLifeBonus extends Bonus {
    private Random r = new Random();
    private int lifePoints;

    public AddLifeBonus(int row, int col) {
        this.setRow(row);
        this.setCol(col);
        this.setSymbol(Global.lifeSymbol);

        this.lifePoints = r.nextInt(3) + 1;
    }

    @Override
    public void setEffect(Tank tank) {
        tank.setLife(lifePoints);
    }

}
