package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2468_안전영역 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[][] map;
	static int[][] visit;
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int mnDep = 1;
		int mxDep = 1;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mnDep = Math.min(mnDep, map[i][j]);
				mxDep = Math.max(mxDep, map[i][j]);
			}
		}

		// start
		answer = 1;
		for (int i = mnDep; i < mxDep; ++i) {
			visit = new int[N][N];
			answer = Math.max(answer, func(i));
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static int func(int dep) {
		int ret = 0;
		Queue<Point> q = new LinkedList<>();
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] <= dep) {
					map[i][j] = -1;
				} else {
					list.add(new Point(j, i));
				}
			}
		}
		for (Point l : list) {
			if (visit[l.y][l.x] != 0)
				continue;
			q.offer(l);
			visit[l.y][l.x] = 1;
			ret++;
			while (!q.isEmpty()) {
				Point now = q.poll();
				for (int dir = 0; dir < 4; ++dir) {
					int nx = now.x + dx[dir];
					int ny = now.y + dy[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visit[ny][nx] != 0)
						continue;
					if (map[ny][nx] == -1)
						continue;
					visit[ny][nx] = 1;
					q.offer(new Point(nx, ny));
				}
			}
		}
		return ret;
	}
}
