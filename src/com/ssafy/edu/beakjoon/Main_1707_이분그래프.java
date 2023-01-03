package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1707_이분그래프 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[] visit;
	static int K;
	static int V;
	static int E;
	static int flg;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; ++k) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			visit = new int[V + 1];
			for (int i = 0; i < V + 1; ++i)
				list.add(new ArrayList<>());
			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list.get(u).add(v);
				list.get(v).add(u);
			}
			// start
			String[] answer = { "YES", "NO" };
			Arrays.fill(visit, -1);
			flg = 0;
			for (int i = 1; i < V + 1; ++i) {
				if (visit[i] != -1)
					continue;
				visit[i] = 0;
				func(i);
			}
			// end

			// 출력
			System.out.println(answer[flg]);
		}
	}

	private static void func(int n) {
		for (int v : list.get(n)) {
			if (visit[v] != -1 && visit[n] == visit[v]) {
				flg = 1;
//				return;
			}
			if (visit[v] != -1)
				continue;
			visit[v] = (visit[n] + 1) % 2;
			func(v);
		}
	}
}
