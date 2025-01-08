package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

public enum Target {
	LEFT {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 0, -1 };
		}

		@Override
		public Target getOpposite() {
			return Target.RIGHT;
		}
	},
	RIGHT {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 0, 1 };
		}

		@Override
		public Target getOpposite() {
			return Target.LEFT;
		}
	},
	TOP {
		@Override
		public int[] changeRowsCols() {
			return new int[] { -1, 0 };
		}

		@Override
		public Target getOpposite() {
			return Target.BOTTOM;
		}
	},
	BOTTOM {
		@Override
		public int[] changeRowsCols() {
			return new int[] { 1, 0 };
		}

		@Override
		public Target getOpposite() {
			return Target.TOP;
		}
	};

	public abstract int[] changeRowsCols();

	public abstract Target getOpposite();
}
