package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11660_구간합5 {
	static int[][] map;
	static int[] arr;
	static int[] nums;
	static int[] visit;
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		int[][] sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				sum[i][j] += sum[i - 1][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			sb.append(sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1]);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
