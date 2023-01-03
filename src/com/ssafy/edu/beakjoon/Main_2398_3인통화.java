package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2398_3인통화 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point>[] list;
	static int[][] map;
	static int[] arr;
	static int[][] dist;
	static int[][] route;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dist = new int[3][N + 1];
		route = new int[3][N + 1];
		int[] input = new int[3];
		int[][] s = new int[3][N + 1];
		int[][] r = new int[3][N + 1];
		for (int i = 0; i < N + 1; ++i)
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int snd = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			list[fst].add(new Point(snd, val));
			list[snd].add(new Point(fst, val));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; ++i) {
			input[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		// start

		for (int j = 0; j < 3; ++j) {
			for (int i = 1; i < N + 1; ++i) {
				dist[j][i] = Integer.MAX_VALUE;
				route[j][i] = 0;
			}
			func(input[j], j);
			System.arraycopy(dist[j], 0, s[j], 0, N + 1);
			System.arraycopy(route[j], 0, r[j], 0, N + 1);
		}

		int mn = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 1; i < N + 1; ++i) {
			int sum = 0;
			for (int j = 0; j < 3; ++j)
				sum += s[j][i];
			if (sum < mn) {
				mn = sum;
				idx = i;
			}
		}
		int disSum = 0;
		List<Point> v = new ArrayList<>();
		for (int j = 0; j < 3; ++j) {
			for (int i = idx; i != input[j];) {
				disSum++;
				v.add(new Point(i, r[j][i]));
				i = r[j][i];
			}
		}
		// end

		// 출력
		System.out.println(mn + " " + disSum);
		for (int i = 0; i < v.size(); ++i) {
			Point tmp = v.get(i);
			System.out.println(tmp.x + " " + tmp.y);
		}
	}

	private static void func(int fst, int idx) {
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.y, b.y));
		pq.offer(new Point(fst, 0));
		dist[idx][fst] = 0;
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (dist[idx][now.x] < now.y)
				continue;
			for (Point next : list[now.x]) {
				if (now.y + next.y < dist[idx][next.x]) {
					dist[idx][next.x] = now.y + next.y;
					route[idx][next.x] = now.x;
					pq.offer(new Point(next.x, now.y + next.y));
				}
			}
		}
	}
}
