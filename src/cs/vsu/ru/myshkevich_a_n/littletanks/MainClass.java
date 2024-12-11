package cs.vsu.ru.myshkevich_a_n.littletanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Game;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.GameStatus;

public class MainClass {
	public static void main(String[] args) {
		Game game = new Game(0, 1);
		GameStatus status = GameStatus.NOTHING;
		while (true) {
			status = game.gameStep();
			if (status == GameStatus.STOP) {
				return;
			}
			if (status == GameStatus.LOSE) {
				game = new Game(0, 1);
			}
			if (status == GameStatus.WIN) {
				game = new Game(game.getScore(), game.getLvl() + 1);
			}
		}
	}
}
