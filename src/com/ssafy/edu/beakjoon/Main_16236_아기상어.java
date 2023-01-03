package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16236_아기상어 {
	// bfs를 통해 최단거리 계산 장애물도
	// 같다면 위 왼 우선
	static int[] dx = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int[] dy = { -1, 0, 1, 0, 1, -1, 1, -1 };
	static int[][] map;
	static int[][] visit;
	static int N;
	static int M;
	static int cnt;
	static int time;
	static BS bs;

	static class BS {
		int x;
		int y;
		int level;
		int eat;

		BS(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.eat = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					bs = new BS(j, i, 2);
				else if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		// start
		func();
		// end

		// 출력
		System.out.println(time);
	}

	private static void func() {
		while (cnt > 0) {
			if (!findFish()) {
				return;
			}
		}
	}

	private static boolean findFish() {
		Queue<Point> q = new LinkedList<>();
		visit = new int[N][N];
		q.offer(new Point(bs.x, bs.y));
		visit[bs.y][bs.x] = 1;
		map[bs.y][bs.x] = 0;
		List<Point> fish = new ArrayList<>();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int sz = 0; sz < size; ++sz) {
				Point now = q.poll();
				for (int dir = 0; dir < 4; ++dir) {
					int ny = now.y + dy[dir];
					int nx = now.x + dx[dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visit[ny][nx] != 0)
						continue;
					if (map[ny][nx] > bs.level)
						continue;
					visit[ny][nx] = visit[now.y][now.x] + 1;
					q.offer(new Point(nx, ny));
					// 가장가까운 거리 먹음
					if (map[ny][nx] > 0 && map[ny][nx] < bs.level) {
						fish.add(new Point(nx, ny));
					}
				}

			}
			if (!fish.isEmpty()) {
				eatFish(fish);
				return true;
			}
		}
		return false;
	}

	private static void eatFish(List<Point> fish) {
//		for (int i = 0; i < N; ++i) {
//			for (int j = 0; j < N; ++j) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		Collections.sort(fish, (a, b) -> {
			if (a.y == b.y)
				return Integer.compare(a.x, b.x);
			return Integer.compare(a.y, b.y);

		});
		int ny = fish.get(0).y;
		int nx = fish.get(0).x;
		map[ny][nx] = 0;
		bs.x = nx;
		bs.y = ny;
		bs.eat++;
		if (bs.eat == bs.level) {
			bs.level++;
			bs.eat = 0;
		}
		time += visit[ny][nx] - 1;
//		System.out.println(time);
		cnt--;

		fish.clear();
	}
}
