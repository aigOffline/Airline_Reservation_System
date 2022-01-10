package fruit;

public class Fruit {

	private String color;
	private boolean rotten;
	private static int next_id;
	private int id;
	private String className;
	
	//contructor 
	public Fruit(){
		next_id++;
		id = next_id;
		className = "Fruit";
	}
	public Fruit(String color, boolean rotten){
		//this() invoke defult constru. 
		this();
		this.color = color;
		this.rotten = rotten;
	}
	
	public void setClassName(String name) {
		this.className = name;
	}
	
	
	public String getClassName() {
		return className;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getRotten() {
		return rotten;
	}
	public void setRotten(Boolean rotten) {
		this.rotten = rotten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return className+" "+getId()+" "+getColor()+" "+getRotten();
	}
	
	public boolean equals(Object ob) {
		Fruit f = (Fruit)ob;
		if(!getClassName().equals(f.getClassName())) return false;
		return getColor().equals(f.getColor()) && getRotten() == f.getRotten();
	}

}
