package com.ssafy.edu.Test;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution_Atest1 {
	static int N;
	static int answer;
	static int answer2;
	static int[][] arr;
	static List<Home> home;

	static class Home {
		int x;
		int y;
		int dis;

		Home(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	// N = 20
	// -15 ~ 15
	// 30*30 = 900

	// 900C1 = 900
	// 900C2 = 450 * 899
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; ++t) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[31][31];
			home = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				home.add(new Home(x + 15, y + 15, dis));
				arr[y + 15][x + 15] = i + 1;
			}
			// start
			answer = Integer.MAX_VALUE;
			answer2 = Integer.MAX_VALUE;
			for (int i = 0; i < 31 * 31; ++i) {
				int ny = i / 31;
				int nx = i % 31;
				if (arr[ny][nx] == 0) {
					arr[ny][nx] = -1;
					func(ny, nx, 0, new Point[2], i);
					arr[ny][nx] = 0;
				}
			}
//			for (int i = 0; i < 31; ++i) {
//				for (int j = 0; j < 31; ++j) {
//					if (arr[i][j] == 0) {
//						arr[i][j] = -1;
//						func(i, j, 0, new Point[2], i * 30 + j);
//						arr[i][j] = 0;
//					}
//				}
//			}
			if (answer == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE)
				answer = -1;
			else if (answer == Integer.MAX_VALUE && answer2 != Integer.MAX_VALUE)
				answer = answer2;
			// end
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void func(int y, int x, int n, Point[] p, int start) {
		p[n] = new Point(x, y);
		findMnDis(n, p);
		if (n == 1) {
			return;
		}
		for (int i = start; i < 31 * 31; ++i) {
			int ny = i / 31;
			int nx = i % 31;
			if (arr[ny][nx] == 0) {
				arr[ny][nx] = -1;
				func(ny, nx, n + 1, p, i);
				arr[ny][nx] = 0;
			}
		}
//		for (int i = y; i < 31; ++i) {
//			for (int j = 0; j < 31; ++j) {
//				if (arr[i][j] == 0) {
//					arr[i][j] = -1;
//					func(i, j, n + 1, p, i * 30 + j);
//					arr[i][j] = 0;
//				}
//			}
//		}
	}

	private static void findMnDis(int n, Point[] p) {
		int sum = 0;
		int[] flg = { 1, 1 };
		for (int i = 0; i < N; ++i) {
			int mn = Integer.MAX_VALUE;
			Home now = home.get(i);
			int dis1 = calc(now.y, now.x, p[0].y, p[0].x);
			int dis2 = Integer.MAX_VALUE;
			if (n == 1)
				dis2 = calc(now.y, now.x, p[1].y, p[1].x);
			int mnDis = Math.min(dis1, dis2);
			if (mnDis > now.dis) {
				flg[n] = 0;
				break;
			}
			sum += mnDis;
		}
		if (flg[n] == 1 && n == 0 && sum < answer) {
			answer = sum;
		}
		if (flg[n] == 1 && n == 1 && sum < answer2) {
			answer2 = sum;
		}
	}

	private static int calc(int y, int x, int y2, int x2) {
		return Math.abs(y - y2) + Math.abs(x - x2);
	}
}
