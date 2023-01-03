package com.ssafy.edu.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest3 {

	public static void main(String[] args) {
		ArrayList<Point> points=new ArrayList<>();
		Point[] ps=new Point[10];
		ps[0]=new Point(2,3);
		ps[1]=new Point(0,0);
		ps[2]=new Point(4,2);
		ps[3]=new Point(2,4);
		ps[4]=new Point(3,1);
		ps[5]=new Point(5,0);
		ps[6]=new Point(3,4);
		ps[7]=new Point(3,-4);
		ps[8]=new Point(-1,-1);
		ps[9]=new Point(3,4);
		for (int i = 0; i < ps.length; i++) {
			if(!points.contains(ps[i])) {
				points.add(ps[i]);
			}
		}
		System.out.println(points.size());
		System.out.println("-------------------");
		for (Point t: points) {
			System.out.println(t);
		}
		points.sort(new PointManhattan());		System.out.println("-------------------");
		for (Point t: points) {
			System.out.println(t);
		}
	}

}

