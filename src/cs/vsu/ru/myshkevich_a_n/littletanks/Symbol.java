package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Symbol {
	public String up;
	public String down;

	public Symbol(String str) {
		str = String.format("%-4s", str).replace(' ', '.');
		this.up = str.charAt(0) + " " + str.charAt(1) + " ";
		this.down = str.charAt(2) + " " + str.charAt(3) + " ";
	}
}
