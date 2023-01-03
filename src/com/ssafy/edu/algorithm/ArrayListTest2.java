package com.ssafy.edu.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest2 {

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
		points.sort(new PointManhattan());
		System.out.println("--------------------------------------");
		for (Point p : points) {
			System.out.println(p);
		}
	}

}

