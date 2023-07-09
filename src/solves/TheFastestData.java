package solves;

import java.util.Objects;

public class TheFastestData {
	private int a;
	private int b;

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}
		
	public TheFastestData(int a,int b) {
		this.a = a;
		this.b = b;		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheFastestData other = (TheFastestData) obj;
		return a == other.a && b == other.b;
	}
}