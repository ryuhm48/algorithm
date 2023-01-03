package com.ssafy.edu.algorithm;

import java.util.Comparator;

public class YourComp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);
	}
}
