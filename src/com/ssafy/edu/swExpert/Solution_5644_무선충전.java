package com.ssafy.edu.swExpert;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_5644_무선충전 {
	static int answer;
	static int N = 10;
	static int M;
	static int A;
	static int[][][] map;
	static int[] a;
	static int[] b;
	static int[] bc;
	static int[] dx = { 0, 0, 1, 0, -1, 1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, 0, -1, 1, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			a = new int[M + 1];
			b = new int[M + 1];
			map = new int[N][N][9];
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i < M + 1; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M + 1; ++i) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				// 겹침처리
				func(y, x, c, p, i + 1);
			}
			// start
			answer = 0;
			int ax = 0;
			int ay = 0;
			int bx = 9;
			int by = 9;
			for (int i = 0; i < M + 1; ++i) {
				int nax = ax + dx[a[i]];
				int nay = ay + dy[a[i]];
				int nbx = bx + dx[b[i]];
				int nby = by + dy[b[i]];
				int numA = calcMax(nay, nax);
				int numB = calcMax(nby, nbx);

				if (numA == numB && numB != 0) {
					int tmpB = calcNext(nby, nbx, numB);
					int tmpA = calcNext(nay, nax, numA);
					if (tmpB == 0 && tmpA == 0) {

					} else if (tmpB != 0 && tmpA == 0) {
						numB = tmpB;
					} else if (tmpB == 0 && tmpA != 0) {
						numA = tmpA;
					} else {
						if (map[nby][nbx][tmpB] > map[nay][nax][tmpA]) {
							numB = tmpB;
						} else if (map[nby][nbx][tmpB] <= map[nay][nax][tmpA]) {
							numA = tmpA;
						}
					}
				}
				if (numA == numB)
					answer += map[nay][nax][numA];
				else
					answer += map[nay][nax][numA] + map[nby][nbx][numB];

				ax = nax;
				ay = nay;
				bx = nbx;
				by = nby;

			}
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int calcMax(int y, int x) {
		int idx = 0;
		int mx = 0;
		for (int i = 1; i <= 8; ++i) {
			if (map[y][x][i] > mx) {
				mx = map[y][x][i];
				idx = i;
			}
		}
		return idx;
	}

	private static int calcNext(int y, int x, int idx) {
		int newIdx = 0;
		int mx = 0;
		for (int i = 1; i <= 8; ++i) {
			if (map[y][x][i] > mx && i != idx) {
				mx = map[y][x][i];
				newIdx = i;
			}
		}
		return newIdx;
	}

	private static void func(int y, int x, int c, int p, int idx) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		map[y][x][idx] = p;
		int cnt = 0;
		while (!q.isEmpty() && cnt < c) {
			int sz = q.size();
			for (int i = 0; i < sz; ++i) {
				Point now = q.poll();
				for (int dir = 1; dir < 5; ++dir) {
					int nx = now.x + dx[dir];
					int ny = now.y + dy[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (map[ny][nx][idx] == p)
						continue;
					map[ny][nx][idx] = p;
					q.offer(new Point(nx, ny));
				}
			}
			cnt++;
		}
	}
}