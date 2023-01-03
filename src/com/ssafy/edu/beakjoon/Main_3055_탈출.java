package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3055_탈출 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<point> water;
	static char[][] map;
	static int[][] visit;
	static int R;
	static int C;
	static int answer;
	static point hedgehog;
	static point cave;

	static class point {
		int x;
		int y;
		int flg;

		point(int x, int y, int flg) {
			this.x = x;
			this.y = y;
			this.flg = flg;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new int[R][C];
		hedgehog = new point(0, 0, 0);
		cave = new point(0, 0, 0);
		water = new ArrayList<>();
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < C; ++j) {
				if (map[i][j] == '*') {
					water.add(new point(j, i, 1));
				} else if (map[i][j] == 'S') {
					hedgehog.x = j;
					hedgehog.y = i;
				} else if (map[i][j] == 'D') {
					cave.x = j;
					cave.y = i;
				}
			}
		}
		// start
		// end

		// 출력
		if (!func())
			System.out.println("KAKTUS");
	}

	private static boolean func() {
		Queue<point> q = new LinkedList<>();
		for (point w : water) {
			q.offer(w);
			visit[w.y][w.x] = 2;
		}
		q.offer(hedgehog);
		visit[hedgehog.y][hedgehog.x] = 1;

		while (!q.isEmpty()) {
			int sz = q.size();
			answer++;
			for (int i = 0; i < sz; ++i) {
				point now = q.poll();
				int flg = now.flg;// 0 고슴도치 1 물
				for (int dir = 0; dir < 4; ++dir) {
					int nx = now.x + dx[dir];
					int ny = now.y + dy[dir];
					if (nx < 0 || nx >= C || ny < 0 || ny >= R)
						continue;
					if (visit[ny][nx] == 2)
						continue;
					if (flg == 0 && visit[ny][nx] == 1)
						continue;
					if (map[ny][nx] == 'X')
						continue;
					if (map[ny][nx] == 'D') {
						if (flg == 1)
							continue;
						System.out.println(answer);
						return true;
					}
					visit[ny][nx] = flg + 1;
					q.offer(new point(nx, ny, flg));
				}
			}
		}
		return false;
	}
}
