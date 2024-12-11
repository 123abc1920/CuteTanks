package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class HealthEnemy extends Enemy {

    public HealthEnemy(int row, int col, Target target) {
        super(row, col, target);

        this.setLife(3);
        this.setArmor(0);
        this.setCoreVelocity(1);
    }
}
