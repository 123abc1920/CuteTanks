package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Tank extends Cell {
    protected Target target;

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
