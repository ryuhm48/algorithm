package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17471_게리맨더링 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		arr = new int[N];
		for (int i = 0; i < N + 1; ++i) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int to = i;
			for (int j = 0; j < num; ++j) {
				int from = Integer.parseInt(st.nextToken())-1;
				list.get(to).add(from);
			}
		}
		// start
		answer = Integer.MAX_VALUE;
		func();
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func() {
		for (int i = 0; i < N / 2; ++i) {
			int[] place = new int[N];
			for (int j = N - 1; j >= N - 1 - i; --j)
				place[j] = 1;
			do {
				Set<Integer> s1 = new HashSet<>();
				Set<Integer> s2 = new HashSet<>();
//				List<Integer> list1 = new ArrayList<>();
//				List<Integer> list2 = new ArrayList<>();
				for (int k = 0; k < N; ++k) {
					if (place[k] == 1)
						s1.add(k);
					else
						s2.add(k);
				}
				int sum1 = bfs(s1, s1.size());
				int sum2 = bfs(s2, s2.size());
				if (sum1 == -1 || sum2 == -1)
					continue;
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			} while (next_permutation(N - 1, place));
		}
	}

	private static int bfs(Set<Integer> s, int size) {
		Queue<Integer> q = new LinkedList<>();
		visit = new int[N];
		int st = s.iterator().next();
		visit[st] = 1;
		q.offer(st);
		int cnt = 0;
		int sum = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			sum += arr[now];
			for (int d = 0; d < list.get(now).size(); ++d) {
				int next = list.get(now).get(d);
				if (visit[next] == 1)
					continue;
				if (!s.contains(next))
					continue;
				visit[next] = 1;
				q.offer(next);
			}
		}
		if (cnt == size) {
			return sum;
		}
		return -1;
	}

	private static boolean next_permutation(int sz, int[] place) {
		int i = sz;
		while (i > 0 && place[i - 1] >= place[i])
			--i;
		if (i == 0)
			return false;
		int j = sz;
		while (place[j] <= place[i - 1])
			--j;
		int tmp = place[j];
		place[j] = place[i - 1];
		place[i - 1] = tmp;
		int k = sz;
		while (i <= k) {
			tmp = place[k];
			place[k--] = place[i];
			place[i++] = tmp;
		}
		return true;
	}
}
