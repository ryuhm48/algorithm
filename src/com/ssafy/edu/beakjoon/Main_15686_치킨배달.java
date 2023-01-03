package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15686_치킨배달 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> list;
	static List<Point> list2;
	static int[][] map;
	static int N;
	static int M;
	static int cnt;
	static int[] comb;
	static List<Point> chicken;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Point(j, i));
				} else if (map[i][j] == 1)
					list2.add(new Point(j, i));
			}
		}

		comb = new int[list.size()];
		for (int i = list.size() - M; i < list.size(); ++i)
			comb[i] = 1;

		int answer = Integer.MAX_VALUE;
		do {
			cnt++;
			chicken = new ArrayList<>();
			for (int i = 0; i < list.size(); ++i) {
				if (comb[i] == 1)
					chicken.add(list.get(i));
			}
			int tmpSum = 0;
			for (Point now : list2) {
				tmpSum += func(now);
			}
			answer = Math.min(answer, tmpSum);
		} while (np(list.size() - 1));
		// 출력
		System.out.println(answer);

	}

	private static int func(Point start) {
		int dirMn = Integer.MAX_VALUE;
		for (Point h : chicken) {
			dirMn = Math.min(dirMn, Math.abs(h.x - start.x) + Math.abs(h.y - start.y));
		}
		return dirMn;
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && comb[i - 1] >= comb[i])
			--i;
		if (i == 0)
			return false;
		int j = size;
		while (comb[i - 1] >= comb[j])
			--j;
		int tmp = comb[j];
		comb[j] = comb[i - 1];
		comb[i - 1] = tmp;
		int k = size;
		while (i < k) {
			tmp = comb[k];
			comb[k--] = comb[i];
			comb[i++] = tmp;
		}
		return true;
	}
}
