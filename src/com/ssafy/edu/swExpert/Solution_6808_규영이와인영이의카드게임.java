package com.ssafy.edu.swExpert;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_6808_규영이와인영이의카드게임 {
	static int[] arr;
	static int[] arr2;
	static int[] visit;
	static int win, lose;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[9];
			arr2 = new int[19];
			visit = new int[19];

			for (int i = 0; i < 9; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				arr2[arr[i]] = 1;
			}
			win = 0;
			lose = 0;
			func(0, 0, 0);
			System.out.printf("#%d %d %d\n", test_case, win, lose);
		}
	}

	private static void func(int n, int w, int l) {
		if (n == 9) {
			// win lose
			if (w > l) {
				win++;
			} else {
				lose++;
			}
			return;
		}

		for (int i = 1; i < 19; ++i) {
			if (visit[i] == 1 || arr2[i] == 1)
				continue;
			int wc = 0;
			int lc = 0;
			if (i < arr[n])
				wc = i + arr[n];
			else
				lc = i + arr[n];
			visit[i] = 1;
			func(n + 1, w+wc, l+lc);
			visit[i] = 0;
		}
	}
}