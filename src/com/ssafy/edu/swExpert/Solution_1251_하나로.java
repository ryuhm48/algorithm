package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_1251_하나로 {
	static double answer;
	static int N;
	static double E;
	static int[][] arr;
	static int[] visit;

	static class point {
		int x;
		int y;
		int idx;
		double dis;

		point(int x, int y, int idx, double dis) {
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.dis = dis;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			visit = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			// start
			answer = 0.;
			int cnt = 0;
			PriorityQueue<point> pq = new PriorityQueue<>((point a, point b) -> {
				return Double.compare(a.dis, b.dis);
			});
			pq.offer(new point(arr[0][0], arr[0][1], 0, 0));
			while (!pq.isEmpty() && cnt < N) {
				point now = pq.poll();
				if(visit[now.idx]==1)continue;
				visit[now.idx] = 1;
				answer += now.dis;
				cnt++;
				for (int i = 0; i < N; ++i) {
					if (visit[i] != 0 || now.idx == i)
						continue;
					double tmpDis = Math.pow(Math.abs(now.x - arr[i][0]), 2) + Math.pow(Math.abs(now.y - arr[i][1]), 2);
					pq.offer(new point(arr[i][0], arr[i][1], i, tmpDis));
				}
			}
			// end

			// 출력
			System.out.printf("#%d %.0f\n", test_case, E * answer);
		}
	}
}