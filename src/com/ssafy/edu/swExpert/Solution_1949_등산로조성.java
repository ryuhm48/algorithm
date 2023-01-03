package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_1949_등산로조성 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int answer;
	static int N;
	static int K;
	static int mx;
	static int[][] map;
	static int[][] visit;

	static class point {
		int x;
		int y;
		int k;
		int dis;
		int h;

		point(int x, int y, int k, int dis, int h) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dis = dis;
			this.h = h;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new int[N][N];
			mx = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > mx)
						mx = map[i][j];
				}
			}
			// start
			answer = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == mx) {
						visit[i][j] = 1;
						func(i, j, 1, 1);
						visit[i][j] = 0;

					}
				}
			}

			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int y, int x, int k, int dep) {
		if (answer < dep)
			answer = dep;
		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (visit[ny][nx] != 0)
				continue;
			if (map[ny][nx] >= map[y][x]) {
				if (k != 0 && map[ny][nx] - K < map[y][x]) {
					int tmp = map[ny][nx];
					visit[ny][nx] = 1;
					map[ny][nx] = map[y][x] - 1;
					func(ny, nx, 0, dep + 1);
					visit[ny][nx] = 0;
					map[ny][nx] = tmp;
				}
				continue;
			}
			visit[ny][nx] = 1;
			func(ny, nx, k, dep + 1);
			visit[ny][nx] = 0;
		}
	}
}