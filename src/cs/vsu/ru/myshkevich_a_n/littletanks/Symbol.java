package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Symbol {
	public String up;
	public String down;

	public Symbol(String str) {
		str = String.format("%-4s", str).replace(' ', '.');
		String up = str.substring(0, str.length() / 2);
		String down = str.substring(str.length() / 2, str.length());
		this.up = up.substring(0, up.length() / 2) + " " + up.substring(up.length() / 2, up.length()) + " ";
		this.down = down.substring(0, down.length() / 2) + " " + down.substring(down.length() / 2, down.length()) + " ";
	}
}
