package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = y; j < y + 10; ++j) {
				for (int k = x; k < x + 10; ++k)
					arr[j][k] = 1;
			}
		}
		int ans = 0;
		for (int i = 1; i < 101; ++i) {
			for (int j = 1; j < 101; ++j) {
				if (arr[i][j] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
