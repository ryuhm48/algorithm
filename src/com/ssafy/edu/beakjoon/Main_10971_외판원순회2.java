package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10971_외판원순회2 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visit = new int[N];
		arr = new int[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// start
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			visit[i] = 1;
			arr[0] = i;
			func(1, i, 0, i);
			visit[i] = 0;
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int n, int pre, int sum, int start) {
		if (n == N) {
			if (map[pre][start] == 0)
				return;
			sum += map[pre][start];
			answer = Math.min(answer, sum);
//			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; ++i) {
			if (visit[i] == 1 || map[pre][i] == 0)
				continue;
			visit[i] = 1;
			int tmp = sum + map[pre][i];
			arr[n] = i;
			func(n + 1, i, tmp, start);
			visit[i] = 0;
		}

	}
}
