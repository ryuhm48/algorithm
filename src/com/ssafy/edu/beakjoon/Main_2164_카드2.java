package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2164_카드2 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; ++i) {
			q.offer(i);
		}
		boolean flg = true;
		while (!q.isEmpty()) {
			if (flg)
				answer = q.poll();
			else {
				q.offer(q.poll());
			}
			flg = !flg;
		}
		System.out.println(answer);
	}
}
