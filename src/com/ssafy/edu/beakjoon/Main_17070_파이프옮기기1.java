package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17070_파이프옮기기1 {
	static int[] dx = { 1, 1, 0, 1, 0, 1, -1, -1 };
	static int[] dy = { 0, 1, 1, 1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static long[][][] dp;
	static int[] st = { 0, 0, 0, 0, 1 };
	static int[] ed = { 0, 0, 2, 3, 3 };
	static int N;
	static long answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		dp = new long[N][N][3];
		dp[0][1][0] = 1;
		map[0][1] = 2;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				// 시작 위치
				if (i == 0 && (j == 0))
					continue;
				for (int k = 0; k < 3; ++k) {
					int nx, ny;

					nx = j + dx[k];
					ny = i + dy[k];

					if (k == 1) {
						int flg = 1;
						for (int l = 0; l < 3; ++l) {
							nx = j + dx[l];
							ny = i + dy[l];
							if (!check(nx, ny) || map[ny][nx] == 1) {
								flg = 0;
								break;
							}
						}
						if (flg == 1) {
							for (int l = 0; l < 3; ++l)
								dp[i + 1][j + 1][k] += dp[i][j][l];
						}
					} else if (check(nx, ny) && map[ny][nx] != 1) {
						dp[ny][nx][k] += dp[i][j][k];
						dp[ny][nx][k] += dp[i][j][1];
					}
				}
			}
		}

		// end

		// 출력
		for (int i = 0; i < 3; ++i)
			answer += dp[N - 1][N - 1][i];
		System.out.println(answer);

	}

	static boolean check(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}
}
