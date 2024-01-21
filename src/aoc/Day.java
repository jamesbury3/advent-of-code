package aoc;

public abstract class Day {
	
	public abstract void solve();

	protected void info(String s) {
		System.out.println(getClass().getName() + "::INFO -- " + s);
	}
}