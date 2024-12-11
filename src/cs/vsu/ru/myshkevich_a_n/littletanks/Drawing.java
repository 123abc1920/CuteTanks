package cs.vsu.ru.myshkevich_a_n.littletanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Game;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Drawing {

	public static void draw(Game game) {
		for (int i = 0; i < Global.size; i++) {
			for (int j = 0; j < Global.size; j++) {
				System.out.print(game.getWorld().drawCell(i, j).up);
			}
			System.out.println();
			for (int j = 0; j < Global.size; j++) {
				System.out.print(game.getWorld().drawCell(i, j).down);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printInfo(Game game) {
		System.out.printf("Score: %d Lifes: %s Armours: %s Velocities: %s%n", game.getScore(), game.getLifes(),
				game.getArmours(), game.getVelocities());
	}

	public static void printWin(boolean isWin) {
		if (isWin) {
			System.out.println("You win");
		} else {
			System.out.println("You lose");
		}
	}
}
