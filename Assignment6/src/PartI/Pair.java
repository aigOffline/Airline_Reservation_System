package PartI;

public class Pair<T, E> {
	private T left;
	private E right;
	
	public Pair(T left, E right) {
		this.left = left;
		this.right = right;
	}
	
	public T getLeft() {
		return left;
	}
	public E getRight() {
		return right;
	}
	
	
}
