package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11286_절댓값힙 {
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
		PriorityQueue<PP> q = new PriorityQueue<>();

		for (int i = 0; i < N; ++i) {
			int tmp = Integer.parseInt(br.readLine());

			if (tmp == 0) {
				if (!q.isEmpty())
					System.out.println(q.peek().neg * q.poll().val);
				else
					System.out.println(0);
				continue;
			}
			int neg = 1;
			if (tmp < 0) {
				neg = -1;
				tmp *= -1;
			}
			q.offer(new PP(tmp, neg));
		}

		System.out.println();
	}
}
