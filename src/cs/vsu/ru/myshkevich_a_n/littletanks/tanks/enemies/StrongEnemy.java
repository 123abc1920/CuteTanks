package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class StrongEnemy extends Enemy {

    public StrongEnemy(int row, int col, Target target) {
        super(row, col, target);

        this.setLife(1);
        this.setArmor(3);
        this.setCoreVelocity(1);
    }
}
