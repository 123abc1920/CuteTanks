package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class FastEnemy extends Enemy {

    public FastEnemy(int row, int col, Target target) {
        super(row, col, target);

        this.setLife(1);
        this.setArmor(0);
        this.setCoreVelocity(3);
    }
}
