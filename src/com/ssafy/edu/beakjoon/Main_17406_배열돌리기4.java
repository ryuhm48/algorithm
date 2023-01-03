package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int[][] arr;
	static int[][] copy;
	static int N;
	static int M;
	static int K;
	static int answer = Integer.MAX_VALUE;

	static int[] perm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<int[]> comb = new ArrayList<>();
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int[] tmp = { r, c, s };
			comb.add(tmp);
		}
		perm = new int[K];
		for (int i = 0; i < K; ++i) {
			perm[i] = i;
		}
		do {
			copy = new int[N][M];
			for (int i = 0; i < N; ++i) {
				System.arraycopy(arr[i], 0, copy[i], 0, M);
			}
			for (int i = 0; i < K; ++i) {
				int[] tmp = comb.get(perm[i]);
				int r = tmp[0];
				int c = tmp[1];
				int s = tmp[2];
				rotate(r - 1, c - 1, s);
			}

			int tmpMn = findMin();
			answer = answer < tmpMn ? answer : tmpMn;
		} while (np(K - 1));

		System.out.println(answer);
	}

	private static void rotate(int r, int c, int s) {
		for (int i = -s; i < 0; ++i) {
			int val = copy[r + i][c + i];
			// 하
			for (int j = r + i + 1; j <= (r - i); ++j) {
				copy[j - 1][c + i] = copy[j][c + i];
			}
			// 좌
			for (int j = c + i + 1; j <= c - i; ++j) {
				copy[r - i][j - 1] = copy[r - i][j];
			}
			// 상
			for (int j = r - i - 1; j >= r + i; --j) {
				copy[j + 1][c - i] = copy[j][c - i];
			}
			// 우
			for (int j = c - i - 1; j >= c + i; --j) {
				copy[r + i][j + 1] = copy[r + i][j];
			}

			copy[r + i][c + i + 1] = val;
		}

	}

	// 최솟값
	private static int findMin() {
		int tmpMn = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			int tmpSum = 0;
			for (int j = 0; j < M; ++j) {
				tmpSum += copy[i][j];
			}
			tmpMn = tmpMn < tmpSum ? tmpMn : tmpSum;
		}
		return tmpMn;
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && perm[i - 1] > perm[i])
			--i;
		int j = size;
		if (i == 0)
			return false;
		while (perm[i - 1] > perm[j])
			--j;
		int tmp = perm[j];
		perm[j] = perm[i - 1];
		perm[i - 1] = tmp;
		int k = size;
		while (i <= k) {
			tmp = perm[i];
			perm[i] = perm[k];
			perm[k] = tmp;
			k--;
			i++;
		}
		return true;
	}
}
