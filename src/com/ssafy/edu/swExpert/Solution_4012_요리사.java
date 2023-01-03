package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_4012_요리사 {
	static int answer;
	static int N;
	static int[][] arr;
	static int[] visit;
	static int[] comb;
	static int[] perm;
	static int[] perm2;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			visit = new int[12870];
			comb = new int[N];

			for (int i = N / 2; i < N; ++i)
				comb[i] = 1;
			int cnt = 0;
			do {
				perm = new int[N / 2];
				perm2 = new int[N / 2];
				int idx = 0;
				int idx2 = 0;

				for (int i = 0; i < N; ++i) {
					if (comb[i] == 1) {
						perm[idx++] = i;
					} else {
						perm2[idx2++] = i;
					}
				}
				int sum = 0;
				for (int i = 0; i < N / 2; ++i) {
					for (int j = 0; j < N / 2; ++j) {
						if (i == j)
							continue;
						sum += arr[perm[i]][perm[j]];
						sum -= arr[perm2[i]][perm2[j]];
					}
				}
				visit[cnt++] += Math.abs(sum);
//				System.out.println(sum);
			} while (nc(N - 1));

			answer = Integer.MAX_VALUE;
			for (int i = 0; i < cnt; ++i) {
				answer = Math.min(answer, visit[i]);
			}
			// 출력
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}

	private static boolean nc(int size) {
		int i = size;
		while (i > 0 && comb[i - 1] >= comb[i])
			--i;
		if (i == 0)
			return false;
		int j = size;
		while (comb[i - 1] >= comb[j])
			--j;
		int tmp = comb[j];
		comb[j] = comb[i - 1];
		comb[i - 1] = tmp;
		int k = size;
		while (i < k) {
			tmp = comb[k];
			comb[k--] = comb[i];
			comb[i++] = tmp;
		}
		return true;
	}
}