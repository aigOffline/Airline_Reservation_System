package fruit;

public class Orange extends Citris{
	private String type;
	
	public Orange() {
		this(null, null, false);
	}
	public Orange(String type, String taste, boolean rotten) {
		super(taste, "orange", rotten);
		this.type = type;
		setClassName("Orange");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return super.toString()+ " "+ getType();
	}

	
	public boolean equals(Object o) {
		
		boolean res = super.equals(o);
		if(res) {
			Orange c = (Orange)o;
			return getType().equals(c.getType());
		}
		return res;
		
	}
}
