package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_9229_한빈 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int s = 0;
			int e = N - 1;
			Arrays.sort(arr);
			while (s < e) {
				int sum = arr[s] + arr[e];
				if (sum == M) {
					answer = sum;
					break;
				} else if (sum > M) {
					e--;
				} else {
					s++;
					answer = Math.max(answer, sum);
				}
			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}