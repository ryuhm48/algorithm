package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] dp;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// start
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 2; i < N + 1; ++i) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		// end

		// 출력
		System.out.println(dp[N]);
	}
}
