package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			arr = new int[N][M];
			visit = new int[N][M];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (arr[i][j] == 1 && visit[i][j] == 0) {
						func(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void func(int y, int x) {
		if (visit[y][x] == 1)
			return;
		visit[y][x] = 1;
		for (int dir = 0; dir < 8; ++dir) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;
			if (visit[ny][nx] == 1)
				continue;
			if (arr[ny][nx] == 0)
				continue;
			func(ny, nx);
		}
	}
}
