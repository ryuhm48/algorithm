package com.ssafy.edu.algorithm;

import java.util.Comparator;

public class PointManhattan implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		int manh1 = Math.abs(p1.getX() - 0) + Math.abs(p1.getY() - 0);
		int manh2 = Math.abs(p2.getX() - 0) + Math.abs(p2.getY() - 0);
		return Integer.compare(manh1, manh2);
	}

}
