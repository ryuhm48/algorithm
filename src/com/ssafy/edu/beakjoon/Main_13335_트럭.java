package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {
	static List<List<Integer>> list;
	static int[] arr;
	static int N;
	static int W;
	static int L;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < W; ++i)
			q.offer(0);
		// start
		int sum = 0;
		int idx = 0;
		int num = 0;
		while (true) {
			answer++;
			int poll = q.poll();
			sum -= poll;
			if (poll != 0)
				num++;
			int tmp = 0;
			if (idx<N &&sum + arr[idx] <= L) {
				sum += arr[idx];
				tmp = arr[idx++];
			}
			q.offer(tmp);

			if (num == N)
				break;
		}

		// end

		// 출력
		System.out.println(answer);
	}
}
