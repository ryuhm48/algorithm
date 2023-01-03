package com.ssafy.edu.swExpert;

import java.util.Scanner;

public class Solution_1954_달팽이 {
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
			int c = -1, r = 0;
			int cnt = 1;
			int d = 0;
			
			
			while (cnt <= N * N) {
				int nc = c + dc[d];
				int nr = r + dr[d];
				if (check(nc, nr) || snail[nr][nc] != 0) {
					d = (d + 1) % 4;
					continue;
				}
				
				snail[nr][nc] = cnt++;
				c = nc;
				r = nr;
			}

			System.out.printf("#%d\n", t);
			printArray();
		}
		sc.close();

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
