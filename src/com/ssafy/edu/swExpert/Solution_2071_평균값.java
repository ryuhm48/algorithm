package com.ssafy.edu.swExpert;

import java.util.Scanner;

public class Solution_2071_평균값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = 10;
			int[] nums = new int[N];

			for (int i = 0; i < N; ++i) {
				nums[i] = sc.nextInt();
			}

			int sum = 0;
			for (int i = 0; i < N; ++i) {
					sum += nums[i];
			}

			System.out.printf("#%d %.0f\n",t,1.0*sum/N);

		}

		sc.close();
	}

}
