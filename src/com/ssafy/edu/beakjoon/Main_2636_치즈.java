package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int[][] map;
	static int[] arr;
	static int[] nums;
	static int[][] visit;
	static int N;
	static int M;
	static int cnt;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		int preCheese = 0;
		while (bfs(0, 0)) {
			time++;
			preCheese = cnt;
			cnt = 0;
		}
		System.out.println(time);
		System.out.println(preCheese);
	}

	private static boolean bfs(int py, int px) throws InterruptedException {
		visit = new int[N + 2][M + 2];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(px, py));
		visit[py][px] = 1;
		while (!q.isEmpty()) {
			Point pop = q.poll();
			int x = pop.x;
			int y = pop.y;

			for (int dir = 0; dir < 4; ++dir) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || nx > M + 1 || ny < 0 || ny >= N + 1)
					continue;
				if (visit[ny][nx] == 1)
					continue;
				visit[ny][nx] = 1;
				if (map[ny][nx] == 1) {// 치즈 만남 녹음
					map[ny][nx] = 0;
					cnt++;
					continue;
				}
				q.offer(new Point(nx, ny));
			}

		}
		if (cnt == 0)
			return false;
		return true;
	}

}
