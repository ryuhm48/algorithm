package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class PP implements Comparable<PP> {
		int x;
		int y;
		int idx;

		public PP(int x, int y, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "PP [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(PP o) {
			int rx = Integer.compare(this.x, o.x);
			int ry = Integer.compare(this.y, o.y);
			if (rx > 0 && ry > 0)
				return -1;
			else if (rx < 0 && ry < 0)
				return 1;
			return 0;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<PP> q = new PriorityQueue<>();

		PP[] parr = new PP[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int snd = Integer.parseInt(st.nextToken());
			q.offer(new PP(fst, snd, i));
			parr[i] = new PP(fst, snd, i);
		}
		int rank = 1;
		int sz = 1;
		int[] arr = new int[N];
		for(int i=0;i<N;++i) {
			int cnt=0;
			for(int j=0;j<N;++j) {
				if(i==j)continue;
				if(parr[i].compareTo(parr[j])==1) {
					cnt++;
				}
			}
			arr[i]=cnt+1;
		}
		for (int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}
}
