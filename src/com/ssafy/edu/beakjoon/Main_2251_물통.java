package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2251_물통 {
	static int[] dx = { 0, 0, 1, 1, 2, 2 };
	static int[] dy = { 1, 2, 0, 2, 0, 1 };
	static int A, B, C;
	static int[][] visit;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// start
		Set<Integer> s = new HashSet<>();
		visit = new int[A + 1][B + 1];
		// 물통의 최댓값
		int[] mx = { A, B, C };
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, C });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (visit[now[0]][now[1]] == 1)
				continue;
			visit[now[0]][now[1]] = 1;
			// A가 비어있으면 추가
			if (now[0] == 0)
				s.add(now[2]);

			for (int i = 0; i < 6; ++i) {
				// 0이거나 가득참
//				if (now[dx[i]] == 0 || now[dy[i]] == mx[dy[i]])
//					continue;

				int[] after = { now[0], now[1], now[2] };
				// 다 넣는 경우
				after[dy[i]] = now[dx[i]] + now[dy[i]];
				after[dx[i]] = 0;
				// 다못넣는경우
				if (after[dy[i]] > mx[dy[i]]) {
					after[dy[i]] = mx[dy[i]];
					after[dx[i]] = now[dx[i]] - mx[dy[i]] + now[dy[i]];
				}

				q.offer(after);
			}
		}
		// end

		// 출력
		Object[] ans = s.toArray();

		for (int i = 0; i < ans.length; ++i) {
			System.out.printf("%d ", ans[i]);
		}
		System.out.println();
	}
}
