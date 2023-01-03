package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1194_달이차오른다가자 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static char[][] map;
	static int[] arr;
	static int[][][] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;
	static Map<Character, Integer> m;

	static class point {
		int x;
		int y;
		int key;

		point(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M][(2 << 7)];
		m = new HashMap<>();
		for (int i = 0; i < 6; ++i)
			m.put((char) ('a' + i), i);
		point s = null;
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					s = new point(j, i, 0);
				}
				Arrays.fill(visit[i][j], -1);
			}
		}

		// start
		answer = Integer.MAX_VALUE;
		func(s);
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(point s) {
		Queue<point> q = new LinkedList<>();
		visit[s.y][s.x][s.key] = 0;
		map[s.y][s.x] = '.';
		q.offer(new point(s.x, s.y, s.key));

		while (!q.isEmpty()) {
			point now = q.poll();

			for (int dir = 0; dir < 4; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				int nkey = now.key;
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (map[ny][nx] == '#')
					continue;
				if (map[ny][nx] == '1') {
					answer = visit[now.y][now.x][nkey] + 1;
					return;
				}

				if (map[ny][nx] != '.') {
					if (map[ny][nx] >= 'a' && map[ny][nx] <= 'z') {
						nkey |= 1 << m.get(map[ny][nx]);
					} else {
						if ((nkey >> (m.get((char) (map[ny][nx] + 32))) & 1) == 0) {
							continue;
						}
					}
				}
				if (visit[ny][nx][nkey] != -1)
					continue;
				q.offer(new point(nx, ny, nkey));
				visit[ny][nx][nkey] = visit[now.y][now.x][now.key] + 1;
			}
		}
	}
}
