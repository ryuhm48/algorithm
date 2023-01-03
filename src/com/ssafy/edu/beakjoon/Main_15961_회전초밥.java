package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15961_회전초밥 {
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] visit;
	static Set<Integer> S;
	static int N;
	static int D;
	static int K;
	static int C;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new int[D+1];
		S = new HashSet<>();
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(br.readLine());

		// start
		int s = 0;
		int e = 0;
		int cnt = 0;
		// end
		while (s <= N) {
			if (e - s < K) {
				if (visit[arr[e % N]]++ == 0)
					cnt++;
				e++;
			} else {
				if (visit[C] > 0)
					answer = Math.max(answer, cnt);
				else
					answer = Math.max(answer, cnt+1);

				if (visit[arr[s % N]]-- == 1)
					cnt--;
				s++;
			}
		}

		// 출력
		System.out.println(answer);
	}
}
