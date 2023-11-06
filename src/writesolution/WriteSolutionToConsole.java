package writesolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import myinterfaces.Writeble;

/**
 * Solution Conclusion
 */
@SuppressWarnings("unused")
public class WriteSolutionToConsole implements Writeble {
	private final List<Data> list = new ArrayList<>();

	class Data {
		private final int a;
		private final int b;
		private final int c;
		private final int d;

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

		@SuppressWarnings("unused")
		public Data(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Data other = (Data) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
				return false;
			}
			return a == other.a && b == other.b && c == other.c && d == other.d;
		}

		private WriteSolutionToConsole getEnclosingInstance() {
			return WriteSolutionToConsole.this;
		}
	}

	// @Override
	@SuppressWarnings("unused")
	public void add(int a, int b, int c, int d) {
		list.add(new Data(a, b, c, d));
	}

	@SuppressWarnings("unused")
	@Override
	public void clear() {
		list.clear();
	}

	@SuppressWarnings("unused")
	@Override
	public void printAll() {
		list.forEach((System.out::println));
	}
}
