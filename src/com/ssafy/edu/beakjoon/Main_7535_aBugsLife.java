package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7535_aBugsLife {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Integer>[] list;
	static int[][] map;
	static int[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int T;
	static int flg;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList[N + 1];
			visit = new int[N + 1];
			for (int i = 0; i < N + 1; ++i)
				list[i] = new ArrayList<>();
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int fst = Integer.parseInt(st.nextToken());
				int snd = Integer.parseInt(st.nextToken());
				list[fst].add(snd);
				list[snd].add(fst);
			}
			// start
			flg = 1;
			Arrays.fill(visit, -1);
			for (int i = 1; i < N + 1; ++i)
				if(visit[i]==-1)
					func(i);
			// end

			// 출력
			String output = "";
			System.out.printf("Scenario #%d:\n", t + 1);
			if (flg == 0)
				output = "Suspicious bugs found!";
			else
				output = "No suspicious bugs found!";
			System.out.println(output);
			System.out.println();
		}
	}

	private static void func(int fst) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(fst);
		visit[fst] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : list[now]) {
				if (visit[next] == visit[now]) {
					flg = 0;
					return;
				}
				if (visit[next] != -1)
					continue;
				q.offer(next);
				visit[next] = (visit[now] + 1) % 2;
			}
		}
	}
}
