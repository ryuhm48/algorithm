package com.ssafy.edu.algorithm;

public class Point implements Comparable<Point> {
	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", dis=" + (Math.abs(x - 0) + Math.abs(y - 0)) + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.getX())
			return false;
		if (y != other.getY())
			return false;
		return true;
	}

	@Override
	public int compareTo(Point p) {
		int manh1 = Math.abs(x - 0) + Math.abs(y - 0);
		int manh2 = Math.abs(p.getX() - 0) + Math.abs(p.getY() - 0);
		return Integer.compare(manh1, manh2);
	}
}