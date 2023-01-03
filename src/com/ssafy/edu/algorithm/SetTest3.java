package com.ssafy.edu.algorithm;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest3 {

	public static void main(String[] args) {
		HashSet<Point> points = new HashSet<>();
	
		points.add(new Point(2, 3));
		points.add(new Point(0, 0));
		points.add(new Point(4, 2));
		points.add(new Point(2, 4));
		points.add(new Point(3, 1));
		points.add(new Point(3, 1));
		points.add(new Point(5, 0));
		points.add(new Point(3, 4));

		Iterator<Point> iter = points.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(points);
	}

}
