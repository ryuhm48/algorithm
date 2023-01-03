package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2458_키순서 {
	static List<List<Integer>> list1;
	static List<List<Integer>> list2;
	static int[] visit;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list1.get(a).add(b);
			list2.get(b).add(a);
		}

		// start
		answer = 0;
		for (int i = 0; i < N; ++i) {
			visit = new int[N];
			int tmp = func(i, list1) + func(i, list2);
			if (tmp == N + 1)
				answer++;
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static int func(int st, List<List<Integer>> list) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		visit[st] = 1;
		int cnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			int sz = list.get(now).size();
			for (int i = 0; i < sz; ++i) {
				int next = list.get(now).get(i);
				if (visit[next] == 1)
					continue;
				visit[next] = 1;
				q.offer(next);
			}
		}
		return cnt;
	}
}
