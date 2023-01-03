package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13164_행복유치원 {
	static int[] arr;
	static int N;
	static int K;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return -Integer.compare(a, b);
		});
		for (int i = 0; i < N - 1; ++i) {
			pq.offer(arr[i + 1] - arr[i]);
		}

		// start
		K--;
		while (K-- > 0) {
			pq.poll();
		}
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		// end

		// 출력
		System.out.println(answer);

	}
}
