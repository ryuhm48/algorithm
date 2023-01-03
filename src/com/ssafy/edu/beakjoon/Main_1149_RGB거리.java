package com.ssafy.edu.beakjoon;

import java.util.*;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] price = new int[n][3];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				price[i][j] = s.nextInt();
			}
		}

		int[][] dp = new int[n][3];
		dp[0][0] = price[0][0];
		dp[0][1] = price[0][1];
		dp[0][2] = price[0][2];

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < 3; ++j)
				dp[i][j] = Math.min(price[i][j] + dp[i - 1][(j + 1) % 3], price[i][j] + dp[i - 1][(j + 2) % 3]);
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; ++i)
			answer = Math.min(answer, dp[n - 1][i]);
		System.out.println(answer);
	}
}
