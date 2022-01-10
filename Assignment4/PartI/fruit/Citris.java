package fruit;

public class Citris extends Fruit {
	private String taste;
	
	public Citris() {
		this(null, null,false);
	}
	public Citris(String taste, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		setClassName("Citris");
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String toString() {
		return super.toString() +" "+ getTaste();
	}
	
	public boolean equals(Object o) {
		
		boolean res = super.equals(o);
		if(res) {
			Citris c = (Citris)o;
			return getTaste().equals(c.getTaste());
		}
		return res;
		
	}

}

