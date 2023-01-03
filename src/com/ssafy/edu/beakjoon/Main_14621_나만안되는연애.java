package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14621_나만안되는연애 {
	static List<List<Point>> list;
	static int[] arr;
	static int[] visit;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		// 20756kb 248ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		visit = new int[N + 1];
		for (int i = 0; i < N; ++i) {
			// 남자일시 1 여자일시 0
			if (st.nextToken().charAt(0) == 'M')
				arr[i + 1] = 1;
		}

		list = new ArrayList<>();
		for (int i = 0; i < N + 1; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int scd = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			// 성별이 다른 경우만 연결
			if (arr[fst] == arr[scd])
				continue;
			list.get(fst).add(new Point(scd, dist));
			list.get(scd).add(new Point(fst, dist));
		}

		// start
		PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.x, b.x);
		});

		int cnt = 0;
		answer = 0;
		// 1번부터 프림 알고리즘 시작
		pq.offer(new Point(0, 1));
		// pq를 통해 최솟값부터 연결
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			int idx = now.y;
			if (visit[idx] == 1)
				continue;
			visit[idx] = 1;
			answer += now.x;
			cnt++;
			for (int i = 0; i < list.get(idx).size(); ++i) {
				int next = list.get(idx).get(i).x;
				int nextDist = list.get(idx).get(i).y;
				if (visit[next] == 1)
					continue;
				pq.offer(new Point(nextDist, next));
			}
		}

		// end

		// 출력
		if (cnt < N)
			answer = -1;
		System.out.println(answer);
	}
}
