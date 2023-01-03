package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_5215_햄버거다이어트 {
	static int answer;
	static int N;
	static int L;
	static int[] t;
	static int[] K;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			t = new int[N];
			K = new int[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			// start
			func(0, 0, 0);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
			answer = 0;
		}
	}

	private static void func(int n, int sum, int cal) {
		if (n == N) {
			answer = Math.max(answer, sum);
			return;
		}
		if (cal + K[n] <= L)
			func(n + 1, sum + t[n], cal + K[n]);
		func(n + 1, sum, cal);
		// TODO Auto-generated method stub

	}
}