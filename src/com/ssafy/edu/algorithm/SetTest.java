package com.ssafy.edu.algorithm;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		TreeSet<Point> points = new TreeSet<>();
		points.add(new Point(2, 3));
		points.add(new Point(0, 0));
		points.add(new Point(4, 2));
		points.add(new Point(2, 4));
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
