package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

public enum Target {
	LEFT {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 0, -1 };
		}
	},
	RIGHT {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 0, 1 };
		}
	},
	TOP {
		@Override
		public int[] changeRowsCols() {
			return new int[] { -1, 0 };
		}
	},
	BOTTOM {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 1, 0 };
		}
	};

	public abstract int[] changeRowsCols();
}
