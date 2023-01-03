package com.ssafy.edu.swExpert;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution_1247_최적경로 {
	static int answer;
	static int[] visit;
	static Point[] arr;
	static int N;

	static int hx;
	static int hy;
	static int cx;
	static int cy;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			visit = new int[N];
			arr = new Point[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; ++i) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new Point(x, y);
			}
			// start
			func(0, cx, cy, 0);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int n, int px, int py, int sum) {
		if (n == N) {
			int dis = Math.abs(px - hx) + Math.abs(py - hy);

			if (answer > dis + sum)
				answer = dis + sum;
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (visit[i] != 0)
				continue;
			visit[i] = 1;
			int dis = Math.abs(px - arr[i].x) + Math.abs(py - arr[i].y);
			if (answer > sum + dis)
				func(n + 1, arr[i].x, arr[i].y, sum + dis);
			visit[i] = 0;
		}
	}
}