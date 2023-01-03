package com.ssafy.edu.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_813_c {
	static int answer;
	static int N;
	static int[] arr;
	static int[] arr2;
	static int K;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			arr2 = new int[N + 1];
			answer = 0;
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				arr2[arr[i]]++;
			}
			// start
			int last = -1;
			int cnt = 0;
			for (int i = N - 1; i > 0; --i) {
				if (arr[i - 1] > arr[i]) {
					last = i - 1;
					break;
				}
			}
			if (last == -1)
				System.out.println(0);
			else {
				Map<Integer, Integer> m = new HashMap<>();
				for (int i = 0; i < N; ++i) {
					m.put(arr[i], i);
				}
				int idx = last;
				int i = 0;
				while (i <= idx) {
					idx = Math.max(idx, m.get(arr[i]));
					i++;
				}
				Set<Integer> s = new HashSet<>();
				for (i = 0; i <= idx; ++i) {
					s.add(arr[i]);
				}
				System.out.printf("%d\n", s.size());
			}
			// end

			// 출력

		}
	}
}