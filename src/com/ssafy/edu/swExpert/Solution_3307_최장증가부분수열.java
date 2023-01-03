package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_3307_최장증가부분수열 {
	static int answer;
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; ++i) {
		}

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i]=1;
			}

			// start
			for (int i = 1; i < N; ++i) {
				for (int j = 0; j < i; ++j) {
					if (arr[j] < arr[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// end

			// 출력
			answer=0;
			for (int i = 0; i < N; ++i) {
				answer = Math.max(answer, dp[i]);
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}