package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Tree extends Cell {
	public Tree() {
		this.setSymbol(Global.treeSymbol);
	}

	@Override
	public Cell setDestroy(Core core) {
		this.setCore(null);
		core.setNotAvailable();
		return this;
	}

}
