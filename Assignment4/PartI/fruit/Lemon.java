package fruit;

public class Lemon extends Citris {
	private int sourness;
	
	
	public Lemon() {
		this(0, null, false);
	}
	public Lemon(int sourness, String taste, boolean rotten) {
		super(taste, "yellow", rotten);
		this.sourness = sourness;
		setClassName("Lemon");
	}

	public int getSourness() {
		return sourness;
	}

	public void setSourness(int sourness) {
		this.sourness = sourness;
	}
	public String toString() {
		return super.toString() + " "+ getSourness();
	}

	
	public boolean equals(Object o) {
		
		boolean res = super.equals(o);
		if(res) {
			Lemon c = (Lemon)o;
			return getSourness() == c.getSourness();
		}
		return res;
		
	}
}
