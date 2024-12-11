package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class Enemy extends Tank {
    public Enemy(int row, int col, Target target) {
        this.setCol(col);
        this.setRow(row);
        this.setTarget(target);
        this.setLife(1);
        this.setArmor(0);
        this.setCoreVelocity(1);

        this.setSymbolUp(Global.getUpEnemySymbol());
        this.setSymbolDown(Global.getDownEnemySymbol());
        this.setSymbolLeft(Global.getLeftEnemySymbol());
        this.setSymbolRight(Global.getRightEnemySymbol());
    }

	@Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public boolean setDestroy(boolean getFromEnemy) {
        if (!getFromEnemy) {
            if (this.getArmor() >= 0) {
                this.setArmor(this.getArmor() - 1);
                return true;
            }
            this.setLife(-1);
            if (this.getLife() <= 0) {
                this.isKilled = true;
            }
        }
        return true;
    }
}
