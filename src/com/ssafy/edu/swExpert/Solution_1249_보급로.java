package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_1249_보급로 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int answer;
	static int N;
	static int[][] arr;
	static int[][] visit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];

			for (int i = 0; i < N; ++i) {
				String input = br.readLine();
				for (int j = 0; j < N; ++j) {
					arr[i][j] = input.charAt(j) - '0';
				}
				Arrays.fill(visit[i], -1);
			}

			// end
			func(0, 0);
			// 출력
			answer=visit[N-1][N-1];
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		visit[0][0] = 0;
		q.offer(new Point(0, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (!(visit[ny][nx] == -1 || visit[now.y][now.x] + arr[ny][nx] < visit[ny][nx]))
					continue;
				visit[ny][nx] = visit[now.y][now.x] + arr[ny][nx];
				q.offer(new Point(nx, ny));
			}
		}
	}
}