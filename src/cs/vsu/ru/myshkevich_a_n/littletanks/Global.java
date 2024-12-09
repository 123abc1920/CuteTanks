package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.Arrays;
import java.util.List;

public class Global {
    public static final char wallSymbol = '#';
    public static final char waterSymbol = '~';
    public static final char treeSymbol = '@';
    public static final char flagSymbol = '$';
    public static final char spawnerSymbol = 'X';
    public static final char emptySymbol = '.';
    public static final char coreSymbol = 'O';

    public static int size = 13;

    private static final char[] enemySymbols = {'^', 'v', '<', '>'};
    private static final char[] playerSymbols = {'n', 'u', '(', ')'};

    public static final List<Character> TARGETS = Arrays.asList('a', 'd', 'w', 's');

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
