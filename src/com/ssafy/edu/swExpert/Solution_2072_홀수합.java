package com.ssafy.edu.swExpert;

import java.util.Scanner;

public class Solution_2072_홀수합 {
	static int N = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			int[] nums = new int[N];

			for (int i = 0; i < N; ++i) {
				nums[i] = sc.nextInt();
			}

			int sum = sums(nums);

			System.out.println("#" + t + " " + sum);

		}
		sc.close();

	}
	static int sums(int[] nums) {
		int sum=0;
		for (int i = 0; i < N; ++i) {
			if (nums[i] % 2 == 1)
				sum += nums[i];
		}

		return sum;
	}

}
