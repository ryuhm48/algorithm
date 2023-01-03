package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int[][] arr;
	static int[] nums;
	static int[][] visit;
	static int N;
	static int M;
	static int R;
	static int dir;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = Math.min(M, N);
		for (int r = 0; r < R; ++r) {
			for (int i = 0; i < cnt / 2; ++i) {
				int val = arr[i][i];
				// 우
				for (int j = i + 1; j + i < M; ++j) {
					arr[i][j - 1] = arr[i][j];
				}
				// 하
				for (int j = i + 1; j + i < N; ++j) {
					arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];
				}
				// 좌
				for (int j = M - 2 - i; j - i >= 0; --j) {
					arr[N - 1 - i][j + 1] = arr[N - 1 - i][j];
				}
				// 상
				for (int j = N - 2 - i; j - i >= 0; --j) {
					arr[j + 1][i] = arr[j][i];
				}
				arr[i + 1][i] = val;
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
