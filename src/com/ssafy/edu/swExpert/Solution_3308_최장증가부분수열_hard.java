package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_3308_최장증가부분수열_hard {
	static int answer;
	static int N;
	static List<Integer> list;
	static int[] arr;
	static int[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; ++i) {
		}

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = 1;
			}

			// start
			list.add(arr[0]);
			answer = 1;
			for (int i = 1; i < N; ++i) {
				int now = arr[i];
				int idx = lower_bound(list, now);
				if (idx >= list.size()) {
					list.add(now);
				} else {
					list.set(idx, now);
				}
				dp[i] = Math.max(dp[i],idx+1);
				answer = Math.max(answer, dp[i]);
			}
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static int lower_bound(List<Integer> list, int now) {
		int l = 0;
		int r = list.size();
		while (l < r) {
			int mid = (l + r) / 2;
			if (now > list.get(mid)) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return r;
	}
}