package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15683_감시 {
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static List<Point> cctv;
	static int[][] map;
	static int[] visit;
	static int[] dir;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new Point(j, i));
				}
			}
		}
		// start
		answer = Integer.MAX_VALUE;
		dir = new int[cctv.size()];
		func(0, 0);
		// end

		// 출력
		System.out.println(answer);

	}

	private static void func(int n, int st) {
		if (n == cctv.size()) {
			int mn = 0;
			int[][] tmp = new int[N][M];
			for (int i = 0; i < N; ++i) {
				System.arraycopy(map[i], 0, tmp[i], 0, M);
			}

			for (int i = 0; i < cctv.size(); ++i) {
				Point now = cctv.get(i);
				int limit;
				int add;
				switch (tmp[now.y][now.x]) {
				case 1:
					limit = 1;
					add = 1;
					draw(tmp, limit, add, i, now);
					break;
				case 2:
					limit = 3;
					add = 2;
					draw(tmp, limit, add, i, now);
					break;
				case 3:
					limit = 2;
					add = 1;
					draw(tmp, limit, add, i, now);

					break;
				case 4:
					limit = 3;
					add = 1;

					draw(tmp, limit, add, i, now);
					break;
				case 5:
					limit = 4;
					add = 1;
					draw(tmp, limit, add, i, now);
					break;
				}
			}

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (tmp[i][j] == 0)
						mn++;
				}
			}
			answer = Math.min(answer, mn);
			return;
		}
		for (int i = 0; i < 4; ++i) {
			dir[st] = i;
			func(n + 1, st + 1);
			dir[st] = -1;
		}

	}

	private static void draw(int[][] tmp, int limit, int add, int i, Point now) {
		for (int j = 0; j < limit; j += add) {
			int d = (dir[i] + j) % 4;
			for (int len = 1;; ++len) {
				int nx = now.x + (dx[d] * len);
				int ny = now.y + (dy[d] * len);
				if (!check(ny, nx))
					break;
				if (tmp[ny][nx] == 6)// 벽만남
					break;
				else if (tmp[ny][nx] != 0) {// 다른 cctv만남
					continue;
				}
				tmp[ny][nx] = 7;
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}
}
