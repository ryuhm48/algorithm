package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_BFSDFS {
//	static int[][] map;
	static int[] arr;
	static int[] nums;
	static int[] visit;
	static int N;
	static int M;
	static int V;
	static int ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<HashSet<Integer>> map;
	static int mx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		for (int i = 0; i < N + 1; ++i)
			map.add(new HashSet<Integer>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int snd = Integer.parseInt(st.nextToken());
			map.get(fst).add(snd);
			map.get(snd).add(fst);
		}

		visit = new int[N + 1];
		DFS(V);
		System.out.println();
		visit = new int[N + 1];
		BFS(V);
		System.out.println();
	}

	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			Iterator<?> iter = map.get(now).iterator();
			while (iter.hasNext()) {
				int next = (int) iter.next();
				if (visit[next] == 1)
					continue;
				visit[next] = 1;
				q.offer(next);
			}
		}

	}

	private static void DFS(int v) {
		visit[v] = 1;
		System.out.print(v + " ");
		Iterator<?> iter = map.get(v).iterator();
		while (iter.hasNext()) {
			int next = (int) iter.next();
			if (visit[next] == 1)
				continue;
			DFS(next);
		}

	}

}
