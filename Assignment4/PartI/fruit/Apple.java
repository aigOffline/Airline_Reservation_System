package fruit;

public class Apple extends Fruit {
		private String taste;
		private String texture;
	
	public Apple() {
		this(null, null, null,false);
		
	}
	public Apple(String taste, String texture, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		this.texture = texture;
		setClassName("Apple");
		
	
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String toString() {
		//return "Apple "+ getTaste() +" "+getTexture()+" "+getColor()+" "+getRotten();
		return super.toString()+" "+getTaste()+" "+getTexture();
	}
	
	public boolean equals(Object o) {
		
		boolean res = super.equals(o);
		if(res) {
			Apple c = (Apple)o;
			return getTaste().equals(c.getTaste()) && getTexture().equals(c.getTexture());
		}
		return res;
		
	}

}

