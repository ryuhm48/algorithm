package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1600_말이되고픈원숭이 {
	static int[] dx = { 1, -1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { 0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[][][] visit;
	static int W;
	static int H;
	static int K;
	static int answer;

	static class mk {
		int x;
		int y;
		int k;

		mk(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new int[H][W][K + 1];
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(visit[i][j], -1);
			}
		}

		// start
		answer = -1;
		func(0, 0);
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int i, int j) {
		Queue<mk> q = new LinkedList<>();
		q.offer(new mk(j, i, 0));
		visit[i][j][0] = 0;

		while (!q.isEmpty()) {
			mk now = q.poll();

			if (now.x == W - 1 && now.y == H - 1) {
				answer = visit[now.y][now.x][now.k];
				break;
			}
			for (int dir = 0; dir < 12; ++dir) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				int nk = now.k;

				if (dir > 3)
					nk++;

				if (nk > K)
					continue;

				if (nx < 0 || nx >= W || ny < 0 || ny >= H)
					continue;

				if (visit[ny][nx][nk] != -1)
					continue;
				if (map[ny][nx] != 0)
					continue;
				visit[ny][nx][nk] = visit[now.y][now.x][now.k] + 1;
				q.offer(new mk(nx, ny, nk));
			}

		}
	}
}
