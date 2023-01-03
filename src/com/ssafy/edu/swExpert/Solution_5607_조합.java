package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_5607_조합 {
	static long answer;
	static int N;
	static int R;
	static int cnt;
	static int[] fac;
	static final long mod = 1234567891;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			// start
			long a = 1;
			long b = 1;
			for (long i = 1; i < N + 1; ++i) {
				a *= i;
				a %= mod;
			}
			for (long i = 1; i < R + 1; ++i) {
				b *= i;
				b %= mod;
			}
			for (long i = 1; i < N - R + 1; ++i) {
				b *= i;
				b %= mod;
			}
			long exp = mod - 2;
			long b2 = 1;
			while (exp > 0) {
				if (exp % 2 == 1) {
					b2 *= b;
					b2 %= mod;
				}	
				b *= b;
				b %= mod;
				exp /= 2;
			}
			answer = a * b2;
			answer %= mod;
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}