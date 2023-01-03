package com.ssafy.edu.swExpert;

import java.util.Scanner;

public class Solution_1954_달팽이2 {
	static int N;
	static int[][] snail;
	static int[] dc = { 1, 0, -1, 0 };
	static int[] dr = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			N = sc.nextInt();
			snail = new int[N][N];
			dfs(0, 0, 0, 1);

			System.out.printf("#%d\n", t);
			printArray();
		}

		sc.close();
	}

	private static void dfs(int r, int c, int d, int n) {
		snail[r][c] = n;
		if (n == N * N)
			return;
		int nr = r + dr[d];
		int nc = c + dc[d];
		if (check(nc, nr) || snail[nr][nc] != 0) {
			d = (d + 1) % 4;
		}
		r = r + dr[d];
		c = c + dc[d];
		dfs(r, c, d, n + 1);
	}

	static boolean check(int r, int c) {
		return c < 0 || c >= N || r < 0 || r >= N;
	}

	static void printArray() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.printf("%d ", snail[i][j]);
			}
			System.out.println();
		}
	}
	// dr = 1 0 -1 0 1 1 -1 -1
	// dc = 0 1 0 -1 1 -1 1 -1
}
