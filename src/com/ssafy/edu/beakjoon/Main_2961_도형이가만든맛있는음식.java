package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도형이가만든맛있는음식 {
	static int[][] arr;
	static int N;
	static long mn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		mn = Long.MAX_VALUE;
		for (int i = 0; i < 9; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		func(0, 1L, 0L);
		System.out.println(mn);
	}

	private static void func(int n, long mul, long sum) {
		if (n == N) {
			if (sum == 0)
				return;
			mn = mn > Math.abs(sum - mul) ? Math.abs(sum - mul) : mn;
			return;
		}
		func(n + 1, mul * arr[n][1], sum + arr[n][0]);
		func(n + 1, sum, mul);
	}

}
