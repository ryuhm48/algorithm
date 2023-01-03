package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2565_전깃줄 {
	static int[] arr;
	static int[] dp;
	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[500 + 1];
		dp = new int[500 + 1];
		Arrays.fill(arr, -1);
		int mx = 0;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			arr[idx] = val;
			mx = mx > idx ? mx : idx;
		}
		int answer = 0;
		for (int i = 1; i < mx + 1; ++i) {
			if (arr[i] == -1)
				continue;
			dp[i] = 1;
			for (int j = 1; j < i; ++j) {
				if (arr[j] != -1 && arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			answer = Math.max(answer, dp[i]);
		}

		// start

		// end

		// 출력
		System.out.println(N - answer);
	}
}
