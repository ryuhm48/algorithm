package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_2819_격자판의숫자이어붙이기 {
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Set<Integer> s;
	static String nums;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			arr = new int[4][4];
			for (int i = 0; i < 4; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			s = new HashSet<>();
			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 4; ++j) {
					nums = "";
					func(i, j, 0,"");

				}
			}

			System.out.printf("#%d %d\n", test_case, s.size());

		}
	}

	private static void func(int i, int j, int dep, String sum) {
		if (dep == 7) {
//			System.out.println(sum);
			s.add(Integer.valueOf(sum));
			return;
		}

		for (int dir = 0; dir < 4; ++dir) {
			int nx = j + dx[dir];
			int ny = i + dy[dir];
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				continue;
			String tmp = sum + arr[ny][nx];
			func(ny, nx, dep + 1, tmp);
		}
	}
}