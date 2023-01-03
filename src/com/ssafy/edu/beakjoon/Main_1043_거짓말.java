package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1043_거짓말 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] p;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		arr = new int[t];
		p = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i < N + 1; ++i)
			p[i] = i;
		for (int i = 0; i < t; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			union(0, arr[i]);
		}
		for (int i = 0; i < M; ++i) {
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; ++j) {
				int num2 = Integer.parseInt(st.nextToken());
				list.get(i).add(num2);
			}
			int a = list.get(i).get(0);
			for (int j = 1; j < num; ++j) {
				int b = list.get(i).get(j);
				union(a, b);
			}

		}

		// start
		int answer = 0;
		for (int i = 0; i < M; ++i) {
			List<Integer> tmp = list.get(i);
			int flg = 1;
			for (int j = 0; j < tmp.size(); ++j) {
				if (isUnion(0, tmp.get(j))) {
					flg = 0;
					break;
				}
			}
			if (flg == 1) {
				answer++;
			}
		}

		// end

		// 출력
		System.out.println(answer);

	}

	private static boolean isUnion(int a, int b) {
		if (find(a) == find(b))
			return true;
		return false;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (isUnion(a, b))
			return;
		if (a < b) {
			p[b] = a;
		} else {
			p[a] = b;
		}
	}

	private static int find(int a) {
		if (a == p[a])
			return a;
		return p[a] = find(p[a]);
	}
}
