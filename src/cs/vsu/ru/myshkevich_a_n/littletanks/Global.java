package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Global {
	public static char wallSymbol = '#';
	public static char waterSymbol = '~';
	public static char treeSymbol = '@';
	public static char flagSymbol = '$';
	public static char spawnerSymbol = 'X';

	private static char[] enemySymbols = { '^', 'v', '>', '<' };
	private static char[] playerSymbols = { 'n', 'u', ')', '(' };

	public static char getUpPlayerSymbol() {
		return playerSymbols[0];
	}

	public static char getDownPlayerSymbol() {
		return playerSymbols[1];
	}

	public static char getRightPlayerSymbol() {
		return playerSymbols[2];
	}

	public static char getLeftPlayerSymbol() {
		return playerSymbols[3];
	}

	public static char getUpEnemySymbol() {
		return enemySymbols[0];
	}

	public static char getDownEnemySymbol() {
		return enemySymbols[1];
	}

	public static char getRightEnemySymbol() {
		return enemySymbols[2];
	}

	public static char getLeftEnemySymbol() {
		return enemySymbols[3];
	}
}
