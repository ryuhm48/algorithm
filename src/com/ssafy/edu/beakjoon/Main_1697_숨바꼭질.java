	package com.ssafy.edu.beakjoon;
	
	import java.util.*;
	import java.util.List;
	import java.awt.*;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	
	public class Main_1697_숨바꼭질 {
		static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
		static int[] dy = { 1, 1, 2, -1, 1, -1, 1, -1 };
		static List<List<Integer>> list;
		static int[][] map;
		static int[] visit;
		static int[] W;
		static int[] V;
		static int N;
		static int K;
		static int cnt;
	
		public static void main(String[] args) throws Exception {
			// 입력
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
	
			// start
			visit = new int[100001];
			Queue<Integer> q = new LinkedList<>();
			q.offer(N);
			while (!q.isEmpty()) {
				int sz = q.size();
				for (int i = 0; i < sz; ++i) {
					int now = q.poll();
					if (now == K) {
						System.out.println(cnt);
						return;
					}
	
					for (int dir = 0; dir < 3; ++dir) {
						int next = (now + dx[dir]) * dy[dir];
						if (next < 0 || next > 100000)
							continue;
						if (visit[next] == 1)
							continue;
						visit[next] = 1;
						q.offer(next);
					}
				}
				cnt++;
			}
			// end
	
			// 출력
		}
	}
