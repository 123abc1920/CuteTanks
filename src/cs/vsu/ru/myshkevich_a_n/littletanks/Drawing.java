package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Drawing {
    public static void draw(Game game){
        for (int i=0; i<13; i++){
            for (int j=0; j<13; j++){
                System.out.print(game.getWorld().getCell(i, j).getSymbol());
            }
            System.out.println();
        }
    }
}
