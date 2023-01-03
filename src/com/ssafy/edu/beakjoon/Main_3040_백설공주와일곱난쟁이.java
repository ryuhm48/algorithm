package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		nums = new int[9];
		for (int i = 9 - 7; i < 9; ++i)
			nums[i] = 1;
		do {
			int sum = 0;
			for (int i = 0; i < 9; ++i) {
				if (nums[i] == 1)
					sum += arr[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 9; ++i) {
					if (nums[i] == 1)
						System.out.println(arr[i]);
				}
			}

		} while (np(8));
		System.out.println();
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && nums[i - 1] >= nums[i])
			--i;

		if (i == 0)
			return false;

		int j = size;
		while (nums[i - 1] >= nums[j])
			--j;

		int tmp = nums[j];
		nums[j] = nums[i - 1];
		nums[i - 1] = tmp;

		int k = size;
		while (i < k) {
			tmp = nums[k];
			nums[k] = nums[i];
			nums[i] = tmp;
			++i;
			--k;
		}
		return true;
	}
}
