package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1753_최단경로 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Point>> list;
	static int[][] map;
	static int[] dist;
	static int[] visit;
	static int V;
	static int E;
	static int K;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		dist = new int[V + 1];
		visit = new int[V + 1];

		for (int i = 0; i < V + 1; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Point(v, w));
//			list.get(v).add(new Point(u, w));
		}
		// start
		func();
		// end

		// 출력
		for (int i = 1; i < V + 1; ++i) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	private static void func() {
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.y, b.y));
		pq.offer(new Point(K, 0));
		visit[K] = 1;
		for (int i = 1; i < V + 1; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[K] = 0;

		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (dist[now.x] < now.y)
				continue;
			for (int i = 0; i < list.get(now.x).size(); ++i) {
				Point next = list.get(now.x).get(i);
				int nextIdx = next.x;
				int nextDis = next.y;
				if (dist[nextIdx] > now.y + nextDis) {
					dist[nextIdx] = now.y + nextDis;
					pq.offer(new Point(next.x, now.y + nextDis));
				}
			}
		}

	}
}
