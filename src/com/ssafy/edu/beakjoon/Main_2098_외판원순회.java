package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2098_외판원순회 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[][] dp;
	static int[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[1 << N][N];
		arr = new int[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// start
		answer = Integer.MAX_VALUE / 100;
		for (int i = 0; i < (1 << N); ++i) {
			Arrays.fill(dp[i], -1);
		}
		answer = tsp(1, 0);
		// end

		// 출력
		System.out.println(answer);
	}

	private static int tsp(int visited, int city) {
		if (visited == (1 << N) - 1) {
			if (map[city][0] == 0)
				return Integer.MAX_VALUE / 100;
			return map[city][0];
		}
		if (dp[visited][city] != -1)
			return dp[visited][city];

		dp[visited][city] = Integer.MAX_VALUE / 100;
		for (int i = 0; i < N; ++i) {
			if ((visited & (1 << i)) != 0)
				continue;
			if (map[city][i] == 0)
				continue;
			int result = tsp(visited | (1 << i), i) + map[city][i];
			dp[visited][city] = Math.min(dp[visited][city], result);
		}

		return dp[visited][city];
	}
}
