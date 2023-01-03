package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[][] visit;
	static int N;
	static int M;
	static int K;
	static int cnt;
	static int T;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new int[N][M];

			List<Point> list = new ArrayList<>();
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
				list.add(new Point(x, y));
			}

			int answer = 0;
			for (Point now : list) {
				if (visit[now.y][now.x] == 0) {
					func(now);
					answer++;
				}

			}
			System.out.println(answer);
		}
	}

	private static void func(Point start) {
		visit[start.y][start.x] = 1;
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (visit[ny][nx] == 1 || map[ny][nx] == 0)
					continue;
				visit[ny][nx] = 1;
				q.offer(new Point(nx, ny));
			}
		}

	}
}
