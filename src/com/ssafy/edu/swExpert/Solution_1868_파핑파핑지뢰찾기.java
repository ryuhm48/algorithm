package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_1868_파핑파핑지뢰찾기 {
	static int answer;
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				String input = br.readLine();
				for (int j = 0; j < N; ++j) {
					char input2 = input.charAt(j);
					if (input2 == '.')
						map[i][j] = 0;
					else
						map[i][j] = 1;
				}
			}

			// start
			answer = 0;
			// 최소조건 이어진 0이되는 지점을 찾아 클릭
			func();

			// end

			// 출력
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void func() {
		visit = new int[N][N];
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 0 && visit[i][j] == 0 && isZero(i, j)) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 0 && visit[i][j] == 0) {
					cnt++;
					visit[i][j] = 1;
				}
			}
		}
		answer = cnt;
	}

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visit[y][x] = 1;

		while (!q.isEmpty()) {
			Point now = q.poll();

			if (!isZero(now.y, now.x))
				continue;
			for (int dir = 0; dir < 8; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (map[ny][nx] == 1 || visit[ny][nx] == 1)
					continue;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
		}
	}

	private static boolean isZero(int y, int x) {
		for (int dir = 0; dir < 8; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (map[ny][nx] == 1)
				return false;
		}
		return true;
	}
}