package com.ssafy.edu.swExpert;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_2805_농작물수확하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; ++i) {
				String input = br.readLine();
				for (int j = 0; j < N; ++j) {
					arr[i][j] = input.charAt(j) - '0';
				}
			}
			// 7
			// 3 1 3
			// 2 3 2
			// 1 5 1
			// 0 7 0
			// 1 5 1
			// 2 3 2
			// 3 1 3
			//
			// j=|i-n/2|+n/2
			for (int i = 0; i < N; ++i) {
				int next = 0;

				for (int j = 0; j < Math.abs(i - N / 2); ++j) {
					next++;
//					System.out.print(" ");
				}
				for (int j = 0; j < -Math.abs(-i * 2 + N - 1) + N; ++j) {
					answer += arr[i][next++];
//					System.out.print("*");
				}
				for (int j = 0; j < Math.abs(i - N / 2) - N / 2; ++j) {
					next++;
//					System.out.print(" ");
				}
//				System.out.println();
			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}