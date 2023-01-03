package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
	// N 25 * 25
	// 시간복잡도 O(N^2);
	static int[][] map;
	static int[] arr;
	static int[] nums;
	static int[] visit;
	static int N;
	static int M;
	static int dif;
	static int ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int mx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = -1;
		ncr(0, 0, 0);
		System.out.println(ans);
	}

	private static void ncr(int n, int start, int sum) {
		if (n == 3) {
			if (M >= sum && ans < sum)
				ans = sum;
			return;
		}
		for (int i = start; i < N; ++i) {
			ncr(n + 1, i + 1, sum + arr[i]);
		}
	}
}
