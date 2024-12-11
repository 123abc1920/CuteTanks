package cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies;

import java.util.Random;

import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class EnemyFabric {

	public static Enemy createEnemy(int i, int j) {
		Random random = new Random();
		int a = random.nextInt(4);
		switch (a) {
		case 0:
			return new Enemy(i, j, Target.BOTTOM);
		case 1:
			return new FastEnemy(i, j, Target.BOTTOM);
		case 2:
			return new HealthEnemy(i, j, Target.BOTTOM);
		case 3:
			return new StrongEnemy(i, j, Target.BOTTOM);
		default:
			return null;
		}
	}
}
