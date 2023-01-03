package com.ssafy.edu.algorithm;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest2 {

	public static void main(String[] args) {
		TreeSet<String> list = new TreeSet<>();

		list.add("hello");
		list.remove("hello");
		list.clear();

		list.add("eello");
		list.add("aello");
		list.add("aello");
		list.add("bello");
		list.add("cello");
		list.add("dello");
		list.add("fello");

		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(list);
	}

}
