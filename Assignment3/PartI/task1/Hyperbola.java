package task1;

public class Hyperbola {
	private static int nextId;
	private int id;
	private double vertex;
	private double covertex;
	
	public Hyperbola(){
		this(1,1);
	}
	public Hyperbola(double vertex, double covertex) {
		this.vertex = vertex;
		this.covertex = covertex;
		id = nextId;
		nextId++;
	}
	
	public int getId() {
		return id;
	}
	
	public double getVertex() {
		return vertex;
	}
	public void setVertex(double vertex) {
		this.vertex = vertex;
	}
	public double getCovertex() {
		return covertex;
	}
	public void setCovertex(double covertex) {
		this.covertex = covertex;
	}
	
	public double getFocusSquared() {
		//return Math.sqrt(Math.pow(vertex, 2)+Math.pow(covertex, 2));
		return vertex*vertex + covertex*covertex;
	}
}
