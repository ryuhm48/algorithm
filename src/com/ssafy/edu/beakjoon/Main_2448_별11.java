package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_2448_별11 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N * 2];
		func(N - 1, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N * 2; ++j) {
				sb.append(arr[i][j] == 1 ? "*" : " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();	
	}
	
	private static void func(int r, int c, int n) {
		if (n == 3) {
			arr[r][c] = 1;
			arr[r][c + 1] = 1;
			arr[r][c + 2] = 1;
			arr[r][c + 3] = 1;
			arr[r][c + 4] = 1;

			arr[r - 1][c + 1] = 1;
			arr[r - 1][c + 3] = 1;
			arr[r - 2][c + 2] = 1;
			return;
		}
		func(r, c, n / 2);
		func(r, c + n, n / 2);
		func(r - n / 2, c + n / 2, n / 2);

	}

}
