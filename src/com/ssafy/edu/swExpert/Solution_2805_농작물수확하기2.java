package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution_2805_농작물수확하기2 {
	static int[][] map;
	static boolean[][] visit;
	static int sum;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				String input = br.readLine();
				for (int j = 0; j < N; ++j) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			sum = 0;
			bfs();
			System.out.printf("#%d %d\n", test_case, sum);

		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N / 2, N / 2 });
		sum += map[N / 2][N / 2];
		visit[N / 2][N / 2] = true;
		for (int i = 0; i < N / 2; ++i) {
			int size = q.size();
			for (int j = 0; j < size; ++j) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				for (int d = 0; d < 4; ++d) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (visit[nr][nc] == true)
						continue;
					visit[nr][nc] = true;
					sum += map[nr][nc];
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
