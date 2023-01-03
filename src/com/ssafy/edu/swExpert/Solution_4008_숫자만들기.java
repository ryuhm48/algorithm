package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_4008_숫자만들기 {
	static int[] arr;
	static int[] arith;
	static int N;
	static int mx;
	static int mn;

    static int fc;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			arith = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; ++i) {
				arith[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			mx = Integer.MIN_VALUE;
			mn = Integer.MAX_VALUE;

			func(0, arr[0]);
			System.out.println(fc);
			System.out.printf("#%d %d\n", test_case, mx - mn);
		}
	}

	private static void func(int n, int sum) {
		if (n == N - 1) {
			fc++;
			if (mx < sum)
				mx = sum;
			if (mn > sum)
				mn = sum;
			return;
		}
		for (int i = 0; i < 4; ++i) {
			if (arith[i] == 0)
				continue;
			arith[i]--;
			int tmp = calc(sum, n + 1, i);
			func(n + 1, tmp);
			arith[i]++;
		}
	}

	private static int calc(int sum, int n, int i) {
		switch (i) {
		case 0:
			sum += arr[n];
			break;
		case 1:
			sum -= arr[n];
			break;
		case 2:
			sum *= arr[n];
			break;
		case 3:
			sum /= arr[n];
			break;
		}
		return sum;
	}
}