package com.ssafy.edu.Test;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution_Atest2 {
	static int N;
	static int answer;
	static int coreCnt;
	static List<Point> core;
	static int[][] arr;
	static int[] visit;
	static int[] dx = { 1, -1, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0 };
	static int tmpSum;

	// N 12
	// core 12
	// 0 1 2 3 4
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; ++t) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			core = new ArrayList<>();
			visit = new int[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1 && (i != 0 && i != N - 1 && j != 0 && j != N - 1)) {
						core.add(new Point(j, i));
					}
				}
			}

			// start
			answer = Integer.MAX_VALUE;
			coreCnt = -1;
			tmpSum = 0;
			func(0, 0, arr, 0);
			// end
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void func(int n, int sum, int[][] map, int cnt) {
		if (coreCnt != -1 && coreCnt - cnt > core.size() - n)
			return;
		if (n == core.size()) {
			if (cnt > coreCnt)
				answer = Integer.MAX_VALUE;
			if (cnt >= coreCnt) {
				answer = Math.min(answer, sum);
				coreCnt = cnt;
			}
			return;
		}
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; ++i)
			System.arraycopy(map[i], 0, tmp[i], 0, N);

		for (int dir = 0; dir < 4; ++dir) {
			tmpSum = 0;
			int tmpCnt = cnt;
			if (isConnect(core.get(n), tmp, dir)) {
				tmpCnt++;
				func(n + 1, sum + tmpSum, tmp, tmpCnt);
			}
			for (int i = 0; i < N; ++i)
				System.arraycopy(map[i], 0, tmp[i], 0, N);
		}
		func(n + 1, sum, tmp, cnt);
	}

	private static boolean isConnect(Point point, int[][] tmp, int dir) {
		if (dir == 4)
			return true;
		int nx = point.x + dx[dir];
		int ny = point.y + dy[dir];
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if (tmp[ny][nx] != 0)
				return false;
			tmpSum++;
			tmp[ny][nx] = 1;
			nx = nx + dx[dir];
			ny = ny + dy[dir];
		}
		return true;
	}
}