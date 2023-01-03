package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1922_네트워크연결 {
	static int[] p;
	static int E;
	static int V;
	static long answer;

	static class Edge {
		int a;
		int b;
		long val;

		Edge(int a, int b, long val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		p = new int[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.val, b.val));
		for (int i = 0; i < V + 1; ++i)
			p[i] = i;
		for (int i = 0; i < E; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long val = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, val));

		}

		// start
		answer = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (!isUnion(now.a, now.b)) {
				union(now.a, now.b);
				answer += now.val;
			}

		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	private static boolean isUnion(int a, int b) {
		if (find(a) == find(b))
			return true;
		return false;
	}

	private static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

}
