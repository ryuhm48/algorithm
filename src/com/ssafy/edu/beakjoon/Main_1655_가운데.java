package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1655_가운데 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
		PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			int tmp = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				maxQ.offer(tmp);
			} else {
				minQ.offer(tmp);
			}
			if (!maxQ.isEmpty() && !minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
				tmp = maxQ.poll();
				maxQ.offer(minQ.poll());
				minQ.offer(tmp);
			}
			sb.append(maxQ.peek()+"\n");
//			System.out.println(maxQ.peek());
		}
		System.out.println(sb);
	}
}
