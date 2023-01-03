package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int[][] map;
	static int[][] visit;
	static int N;
	static int M;
	static int V;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		visit = new int[N][M];
		BFS(V);
		System.out.println(visit[N - 1][M - 1]);
	}

	private static void BFS(int v) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		visit[0][0] = 1;
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (visit[ny][nx] > 0)
					continue;
				if (map[ny][nx] == 0)
					continue;
				visit[ny][nx] = visit[now.y][now.x] + 1;
				q.offer(new Point(nx, ny));
			}
		}

	}

}
