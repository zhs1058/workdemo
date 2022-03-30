package test;

public class Point<T> {
	private T x;
	private T y;
	
	public Point() {}
	
	public Point(T x ,T y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(T x) {
		this.x = x;
	}
	
	public T getX() {
		return this.x;
	}
	
	
}
