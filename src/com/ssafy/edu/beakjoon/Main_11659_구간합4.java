package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11659_구간합4 {
	static int[][] map;
	static int[] arr;
	static int[] nums;
	static int[] visit;
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static class seg {
		int[] arr;

		seg(int N) {
			arr = new int[N * 4];
		}

		int getVal(int ptr, int st, int ed, int l, int r) {
			if (st > r || ed < l)
				return 0;
			if (l <= st && ed <= r) {
				return arr[ptr];
			}
			return getVal(ptr * 2, st, (st + ed) / 2, l, r) + getVal(ptr * 2 + 1, (st + ed) / 2 + 1, ed, l, r);
		}

		void update(int ptr, int st, int ed, int i, int val) {
			if (st > i || i > ed)
				return;
			if (st == ed) {
				arr[ptr] = val;
				return;
			}
			update(ptr * 2, st, (st + ed) / 2, i, val);
			update(ptr * 2 + 1, (st + ed) / 2 + 1, ed, i, val);

			arr[ptr] = arr[ptr * 2] + arr[ptr * 2 + 1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		int[] sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		seg s = new seg(N);
		for (int i = 1; i <= N; ++i) {
			arr[i - 1] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + arr[i - 1];
			s.update(1, 1, N, i, arr[i - 1]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			sb.append(sum[y] - sum[x - 1]);
//			sb.append("\n");
//			System.out.println(sum[y] - sum[x - 1]);
			System.out.println(s.getVal(1, 1, N, x, y));
		}
//		System.out.println(sb.toString());
	}

}
