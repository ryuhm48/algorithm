package com.ssafy.edu.algorithm;

public class BubleSort {

	public static void main(String[] args) {
		int[] a = { 2, 9, 3, 5, 4, 7, 6, 8, 1 };

		for (int i = 0; i < a.length; ++i) {
			for (int j = i + 1; j < a.length; ++j) {
				if (j - 1 > j) {
					int tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
	}

}
