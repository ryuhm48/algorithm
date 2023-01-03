package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_3238_이항계수구하기 {
	static long answer;
	static long N;
	static long R;
	static int P;

	static long[] fac;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			fac = new long[P + 2];
			// start
			fac[0] = 1;
			for (int i = 1; i < P + 1; ++i) {
				fac[i] = (i * fac[i - 1]) % P;
			}
			answer = 1;
			while (N > 0 || R > 0) {
				long n = N % P;
				long r = R % P;
				if (r > n) {
					answer = 0;
					break;
				}
				answer = (answer * fac[(int) n]) % P;
				for (int i = 0; i < P - 2; ++i) {
					answer = (answer * fac[(int) (n - r)] * fac[(int) r]) % P;
				}
				N /= P;
				R /= P;
			}
			answer %= P;

			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}