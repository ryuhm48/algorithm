package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_7465_창용마을무리의개수 {
	static int answer;
	static int N;
	static int M;
	static int[] p;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Integer.parseInt(br.readLine());

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			for (int i = 1; i <= N; ++i)
				p[i] = i;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			// start
			Set<Integer> s = new HashSet<>();
			// end

			// 출력
			for (int i = 1; i <= N; ++i) {
				s.add(find(p[i]));
			}
			System.out.printf("#%d %d\n", test_case, s.size());
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	private static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}
}