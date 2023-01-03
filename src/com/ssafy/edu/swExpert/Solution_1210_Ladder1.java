package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1210_Ladder1 {
	static int[][] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
//		T = Integer.parseInt(br.readLine());
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int sx = 0, sy = 0;
			arr = new int[100][100];
			for (int i = 0; i < 100; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						sx = j;
						sy = i;
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, func(sy, sx));
		}
	}

	static int[] dx = { 0, 1, 0, -1 };

	private static int func(int y, int x) {
		int dir = 0;
		// 0 위 1 오 3 왼
		while (true) {
			if (y == 0)
				return x;

			// 옆에 사다리 있는지 판별
			for (int d = 1; d < 4; d += 2) {
				int nx = x + dx[d];
				if (nx < 0 || nx >= 100)
					continue;
				if (dir == 0 && arr[y][nx] == 1) {
					dir = d;
					break;
				}
			}
			// 위로 이동
			if (dir == 0) {
				y--;
				continue;
			}
			// 옆으로 이동중
			if (dir == 1 || dir == 3) {
				while (true) {
					int nx = x + dx[dir];
					if (nx < 0 || nx >= 100 || arr[y][nx] != 1)
						break;
					x = nx;
				}
				if (y != 0)
					y--;
				dir = 0;
			}

		}
	}
}