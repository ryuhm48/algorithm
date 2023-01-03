package com.ssafy.edu.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListTest4 {

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(2, 3));
		points.add(new Point(0, 0));
		points.add(new Point(4, 2));
		points.add(new Point(2, 4));
		points.add(new Point(3, 1));
		points.add(new Point(5, 0));
		points.add(new Point(3, 4));
		System.out.println(points.size());
		for (Point p : points) {
			System.out.println(p);
		}
		points.sort((Point p1, Point p2) -> {
			int manh1 = Math.abs(p1.getX() - 0) + Math.abs(p1.getY() - 0);
			int manh2 = Math.abs(p2.getX() - 0) + Math.abs(p2.getY() - 0);
			return Integer.compare(manh1, manh2);
		});
		System.out.println("--------------------------------------");
		for (Point p : points) {
			System.out.println(p);
		}
	}

}
