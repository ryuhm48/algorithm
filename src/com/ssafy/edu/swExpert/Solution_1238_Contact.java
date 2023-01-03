package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_1238_Contact {
	static int answer;
	static int start;
	static int N;
	static int[][] arr;
	static int[] visit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; ++i) {
		}

		int T;
//		T = Integer.parseInt(br.readLine());
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			answer = 0;
			arr = new int[101][101];
			visit = new int[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}
			// start
			answer = 0;
			func(start);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}

	private static void func(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = 1;

		while (!q.isEmpty()) {
			answer = 0;
			int size = q.size();
			for (int sz = 0; sz < size; ++sz) {
				int now = q.poll();
				answer = Math.max(answer, now);
				for (int i = 0; i < arr[now].length; ++i) {
					if (arr[now][i] == 0 || visit[i] == 1)
						continue;
					visit[i] = 1;
					q.offer(i);
				}

			}

		}
	}
}