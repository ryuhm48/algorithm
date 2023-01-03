package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1208_Flatten {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
//		T = Integer.parseInt(br.readLine());
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 1000 * 100

			while (N-- >= 0) {
				int mx = Integer.MIN_VALUE;
				int mn = Integer.MAX_VALUE;
				int idxMx = -1;
				int idxMn = -1;
				for (int i = 0; i < 100; ++i) {
					if (arr[i] < mn) {
						mn = arr[i];
						idxMn = i;
					}
					if (arr[i] > mx) {
						mx = arr[i];
						idxMx = i;
					}
				}
				answer = arr[idxMx] - arr[idxMn];
				arr[idxMn] = mn + 1;
				arr[idxMx] = mx - 1;
//				System.out.printf("#%d %d %d\n", test_case,N, answer);
			}
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}