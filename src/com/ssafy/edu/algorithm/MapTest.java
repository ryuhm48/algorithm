package com.ssafy.edu.algorithm;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, Point> hm = new HashMap<>();
		hm.clear();
		hm.put("a", new Point(1, 2));
		hm.put("b", new Point(2, 3));
		hm.put("b", new Point(3, 5));
		hm.put("b", new Point(-1, 5));
		hm.put("c", new Point(5, 2));
		hm.put("d", new Point(3, 1));
		hm.remove("a");

		System.out.println(hm.size());
		System.out.println(hm.get("a"));
		System.out.println(hm.get("b"));

		Iterator<String> iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Point p = hm.get(key);
			System.out.println(p);
		}

	}

}
