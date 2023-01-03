package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_5656_벽돌깨기 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer;
	static int N;
	static int W;
	static int H;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// start
			answer = Integer.MAX_VALUE;
			func(0, map);
			if (answer == Integer.MAX_VALUE)
				answer = 0;
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int n, int[][] map) {
		if (n == N) {
			int sum = 0;
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; ++j) {
					if (map[i][j] != 0)
						sum++;
				}
			}
			if (sum < answer)
				answer = sum;
			return;
		}
		for (int i = 0; i < W; ++i) {
			int[][] tmp = new int[H][W];
			for (int j = 0; j < H; ++j)
				System.arraycopy(map[j], 0, tmp[j], 0, W);
			if (!shoot(i, tmp))
				continue;
			func(n + 1, tmp);
		}
	}

	private static boolean shoot(int w, int[][] tmp) {
		int h = 0;
		int flg = 0;
		for (; h < H; ++h) {
			if (tmp[h][w] != 0) {
				flg = 1;
				break;
			}
		}
		if (flg == 0)
			return false;
		Queue<Point> q1 = new LinkedList<>();
		q1.offer(new Point(w, h));
		while (!q1.isEmpty()) {
			Point now = q1.poll();
			for (int len = 1; len < tmp[now.y][now.x]; ++len) {
				for (int dir = 0; dir < 4; ++dir) {
					int nx = now.x + dx[dir] * len;
					int ny = now.y + dy[dir] * len;
					if (nx < 0 || nx >= W || ny < 0 || ny >= H)
						continue;
					if (tmp[ny][nx] != 1 && tmp[ny][nx] != 0) {
						q1.offer(new Point(nx, ny));
						continue;
					}
					tmp[ny][nx] = 0;
				}
			}
			tmp[now.y][now.x] = 0;
		}
		for (int j = 0; j < W; ++j) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = H - 1; i >= 0; --i) {
				if (tmp[i][j] != 0)
					q.offer(tmp[i][j]);
				tmp[i][j] = 0;
			}
			int idx = H - 1;
			while (!q.isEmpty()) {
				tmp[idx--][j] = q.poll();
			}
		}
		return true;
	}
}