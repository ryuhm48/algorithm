package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_1861_정사각형방 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int answer = 0;
	static int loc;

	static class xy implements Comparable<xy> {
		int x;
		int y;
		int val;

		xy(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(xy o) {
			return Integer.compare(val, o.val);
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];
			PriorityQueue<xy> pq = new PriorityQueue<>();
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					pq.offer(new xy(j, i, arr[i][j]));
				}
			}
			while (!pq.isEmpty()) {
				xy now = pq.poll();
				func(now.y, now.x, 1, now.val);
			}
			System.out.printf("#%d %d %d\n", test_case, loc, answer);
		}
	}

	private static void func(int y, int x, int dep, int val) {
		visit[y][x] = 1;
		if (dep > answer) {
			answer = dep;
			loc = val;
		}

		for (int dir = 0; dir < 4; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (arr[ny][nx] != arr[y][x] + 1)
				continue;
			if (visit[ny][nx] == 1)
				continue;

			func(ny, nx, dep + 1, val);

		}
	}
}