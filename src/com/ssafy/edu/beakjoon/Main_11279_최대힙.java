package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11279_최대힙 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class PP implements Comparable<PP> {
		int val;
		int neg;

		public PP(int val, int neg) {
			super();
			this.val = val;
			this.neg = neg;
		}

		@Override
		public int compareTo(PP o) {
			int val = Integer.compare(this.val, o.val);
			int neg = Integer.compare(this.neg, o.neg);
			if (val == 0) {
				return neg;
			}
			return val;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));

		for (int i = 0; i < N; ++i) {
			int tmp = Integer.parseInt(br.readLine());

			if (tmp == 0) {
				if (!q.isEmpty())
					System.out.println(q.poll());
				else
					System.out.println(0);
				continue;
			}
			q.offer(tmp);
		}

		System.out.println();
	}
}
