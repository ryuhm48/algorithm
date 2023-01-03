package com.ssafy.edu.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

		list.add("hello");
		list.add("eello");
		list.add("aello");
		list.add("bello");
		list.add("cello");
		list.add("dello");
		list.add(1, "fello");
		list.set(4, "gello");
		list.remove(2);
		list.clear();
		System.out.println(list);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i));
		}
		for (String s : list) {
			System.out.println(s);
		}
		list.sort(new MyComp());
		list.sort(new YourComp());
		Collections.sort(list);
		System.out.println(list);
	}

}
