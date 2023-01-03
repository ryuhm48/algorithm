package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4485_젤다 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[][] map;
	static int[][] dist;
	static int[][] visit;
	static int N;
	static int answer;
	static int cnt = 1;

	static class point {
		int x;
		int y;
		int val;

		point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		map = new int[125][125];
		dist = new int[125][125];
		visit = new int[125][125];
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
					visit[i][j] = 0;
				}
			}
			// start
			func();
			answer = dist[N - 1][N - 1];
			// end

			// 출력
			sb.append("Problem " + cnt++ + ": " + answer + "\n");
//			System.out.println("Problem " + cnt++ + ": " + answer);
		}
		System.out.println(sb.toString());
	}

	private static void func() {
		PriorityQueue<point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
		dist[0][0] = map[0][0];
		visit[0][0] = 1;
		pq.offer(new point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			point now = pq.poll();
			if (dist[now.y][now.x] < now.val)
				continue;
			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (dist[ny][nx] < now.val + map[ny][nx])
					continue;
				if (visit[ny][nx] == 1 && dist[ny][nx] == now.val + map[ny][nx])
					continue;
				dist[ny][nx] = now.val + map[ny][nx];
				visit[ny][nx] = 1;
				pq.offer(new point(nx, ny, now.val + map[ny][nx]));
				if (nx == N - 1 && ny == N - 1)
					return;
			}
		}
	}
}
