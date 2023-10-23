package writesolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import myinterfaces.Writeble;

/**
 * Solution Conclusion
 */
public class WriteSolutionToConsole implements Writeble {
	private List<Data> list = new ArrayList<Data>();

	class Data {
		private int a;
		private int b;
		private int c;
		private int d;

		@Override
		public String toString() {
			return a + " ^ 3 + " + b + " ^ 3 = " + c + " ^ 3 + " + d + " ^ 3";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(a, b, c, d);
			return result;
		}

		public Data(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Data other = (Data) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return a == other.a && b == other.b && c == other.c && d == other.d;
		}

		private WriteSolutionToConsole getEnclosingInstance() {
			return WriteSolutionToConsole.this;
		}
	}

	// @Override
	public void add(int a, int b, int c, int d) {
		list.add(new Data(a, b, c, d));
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public void printAll() {
		list.forEach((data -> {
			System.out.println(data);
		}));
	}
}
