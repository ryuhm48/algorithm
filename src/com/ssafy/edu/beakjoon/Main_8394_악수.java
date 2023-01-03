package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8394_악수 {
	static long[] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N];
		dp[0] = 1;
		dp[1] = 2;

		// start
		for (int i = 2; i < N; ++i) {
			dp[i] = (dp[i - 2] + dp[i - 1])%10;
		}
		// end

		// 출력
		System.out.println(dp[N - 1]);
	}
}
