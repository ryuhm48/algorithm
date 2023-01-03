package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static int[][] map;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static List<List<Integer>> list;
	static int cnt;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new int[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int snd = Integer.parseInt(st.nextToken());
			list.get(fst).add(snd);
			list.get(snd).add(fst);
		}
		dfs(1);
		System.out.println(cnt - 1);

	}

	private static void dfs(int n) {
		visit[n] = 1;
		cnt++;
		List<Integer> now = list.get(n);
		for (int next : now) {
			if (visit[next] == 1)
				continue;
			dfs(next);
		}
	}
}
