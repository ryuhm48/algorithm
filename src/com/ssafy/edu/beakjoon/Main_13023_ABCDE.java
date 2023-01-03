package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13023_ABCDE {
	static List<List<Integer>> list;
	static int[] arr;
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
		list = new ArrayList<>();
//		arr = new int[N];
		for (int i = 0; i < N; ++i)
			list.add(new ArrayList<>());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		// start
		answer = 0;
		// end
		for (int i = 0; i < N; ++i) {
			visit = new int[N];
			visit[i] = 1;
			func(i, 0);
			if (answer == 1)
				break;
		}

		// 출력
		System.out.println(answer);
	}

	private static void func(int n, int dep) {
		if (dep == 4) {
			answer = 1;
//			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = 0; i < list.get(n).size(); ++i) {
			int next = list.get(n).get(i);
			if (visit[next] != 0)
				continue;
			visit[next] = 1;
//			arr[dep] = next;
			func(next, dep + 1);
			visit[next] = 0;
		}
	}
}
