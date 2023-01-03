package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11066_파일합치기 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[][] dp;
	static int[][] sum;
	static int[] arr;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; ++T) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[N + 1][N + 1];
			sum = new int[N + 1][N + 1];
			for (int i = 0; i < N; ++i) {
				dp[1][i] = arr[i];
			}
//			for (int i = 2; i <= N; ++i) {
//				Arrays.fill(dp[i], Integer.MAX_VALUE);
//				for (int j = 0; j < N; ++j) {
//					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dp[1][(j + i - 1) % N]);
//					sum[i][j] += dp[i][j];
//				}
//			}
			for (int i = 2; i <= N; ++i) {
				
			}
			//dp[2][1]=dp[1][1]+dp[1][2]
			//dp
			//dp[4] = dp[2][1]+dp[2][3]
			//dp[4] = dp[3][2]+dp[1][4] dp[3][1]+dp[1][3]

			System.out.println(dp[N][1]);
		}
		// start

		// end

		// 출력
	}
}
