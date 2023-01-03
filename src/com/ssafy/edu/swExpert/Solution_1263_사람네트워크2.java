package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.awt.*;

class Solution_1263_사람네트워크2 {
	static int answer;
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[][] visit;
	static List<List<Integer>> list;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; ++i) {
		}

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			dist = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; ++i)
				list.add(new ArrayList<>());

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0 && i!=j) {
						map[i][j] = Integer.MAX_VALUE/10;
					}
				}
			}
			// start
			answer = 0;
			func();

			// end
			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func() {
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (i == j)
						continue;
					if (map[i][j] <= map[i][k] + map[k][j])
						continue;
					map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		int mx = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			int cnt = 0;
			for (int j = 0; j < N; ++j) {
				if (i == j)
					continue;
				cnt += map[i][j];
			}
			if (cnt < mx) {
				mx = cnt;
			}
		}
		answer = mx;
	}

}