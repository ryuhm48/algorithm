package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	static int[] arr = { 3, 5 };
	static int[] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// start
		int answer = 0;
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
//		for (int i = 0; i < 3; ++i)
//			dp[i] = 1;
		dp[0]=0;
		for (int j = 0; j < 2; ++j) {
			for (int i = 1; i < N + 1; ++i) {
				if (i >= arr[j] &&dp[i - arr[j]]!=Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i - arr[j]] + 1,dp[i]);
				}
			}
		}

		// end

		// 출력
		if (dp[N] == Integer.MAX_VALUE)
			dp[N] = -1;
		System.out.println(dp[N]);
	}
}
