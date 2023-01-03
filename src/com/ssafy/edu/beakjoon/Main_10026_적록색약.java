package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_적록색약 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static char[][] map;
	static int[][] visit;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		// start
		visit = new int[N][N];
		int ans2 = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (visit[i][j] != 0)
					continue;
				ans2 += func1(i, j, 0);
			}
		}
		visit = new int[N][N];
		int ans1 = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (visit[i][j] != 0)
					continue;
				ans1 += func1(i, j, 1);
			}
		}
		// end

		// 출력
		System.out.println(ans1+" "+ans2);
	}

	private static int func1(int py, int px, int flg) {// rg b
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(px, py));
		visit[py][px] = 1;

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (visit[ny][nx] != 0)
					continue;
				if (flg == 0 && checkRGB(now.y, now.x, ny, nx))
					continue;
				if (flg == 1 && map[ny][nx] != map[now.y][now.x])
					continue;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
		}
		return 1;
	}

	private static boolean checkRGB(int y, int x, int ny, int nx) {
		if (map[y][x] == 'B' && map[ny][nx] != map[y][x])
			return true;
		else if ((map[y][x] == 'G' || map[y][x] == 'R') && map[ny][nx] == 'B')
			return true;
		return false;
	}
}
