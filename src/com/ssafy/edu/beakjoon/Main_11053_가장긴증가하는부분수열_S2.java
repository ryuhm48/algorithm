package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열_S2 {
	static int N;
	static int answer;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];

		List<Integer> list = new ArrayList<>();
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		list.add(arr[0]);
		s.add(arr[0]);
		answer = 1;
		for (int i = 1; i < N; ++i) {
			int now = arr[i];
			int idx = lower_bound(list, now);
			if (idx >= list.size()) {
				list.add(idx, now);
				s.add(now);
			} else {
				list.set(idx, now);
				s.add(now);
			}
			int num = idx + 1;
			dp[i] = Math.max(dp[i], num);
			if (!s.contains(now)) {
				list.add(idx, now);
				s.add(now);
			}
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}

	static int lower_bound(List<Integer> list, int num) {
		int l = 0;
		int r = list.size();

		while (l < r) {
			int mid = (l + r) / 2;
			if (list.get(mid) < num) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return r;
	}
}
