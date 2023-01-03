package com.ssafy.edu.swExpert;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] sum = new int[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					sum[i][j] = arr[i][j];
					if (j != 0) {
						sum[i][j] += sum[i][j - 1];
					}
				}
			}
			int answer = 0;
			for (int i = 0; i <= N - M; ++i) {
				for (int j = M - 1; j < N; ++j) {
					int tmp = 0;
					for (int k = i; k < i + M; ++k) {
						tmp += sum[k][j];
						if (j != M - 1) {
							tmp -= sum[k][j - M];
						}
					}
					if (tmp > answer) {
						answer = tmp;
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}