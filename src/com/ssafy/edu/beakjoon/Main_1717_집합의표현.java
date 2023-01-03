package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1717_집합의표현 {
	static int[] p;
	static int[] r;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N + 1];
		r = new int[N + 1];
		for (int i = 1; i < N + 1; ++i) {
			p[i] = i;
			r[i] = 1;
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int flg = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (flg == 0) {
				union(a, b);
			} else {
				if (isUnion(a, b)) {
					sb.append("YES");
//					System.out.println("YES");
				} else {
					sb.append("NO");
//					System.out.println("NO");
				}

				sb.append("\n");
			}
		}

		// start

		// end

		// 출력
		System.out.println(sb.toString());
	}

	private static boolean isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return true;
		return false;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (isUnion(a, b))
			return;
		if (r[a] > r[b]) {
			p[b] = a;
			r[a] += r[b];
		} else {
			p[a] = b;
			r[b] += r[a];
		}
	}

	private static int find(int a) {
		if (a == p[a])
			return a;
		return p[a] = find(p[a]);
	}
}
