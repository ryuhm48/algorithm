package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> list;
	static int[][] map;
	static int[][] list2;
	static int idx;
	static int flg;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list2 = new int[81][2];
//		list = new ArrayList<>();
		for (int i = 0; i < 9; ++i) {
			String input = br.readLine();
			for (int j = 0; j < 9; ++j) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) {
//					list.add(new Point(j, i));
					list2[idx][0] = j;
					list2[idx++][1] = i;

				}
			}
		}

		// start
		flg = 0;
		func(0, 0);
		// end

		// 출력

	}

	private static void func(int n, int st) {
		if (flg == 1)
			return;
		if (n == idx) {
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j)
					System.out.print(map[i][j]);
				System.out.println();
			}
			flg = 1;
			return;
		}
		int nowX = list2[st][0];
		int nowY = list2[st][1];
		int cnt = 0;
		for (int j = 1; j < 10; ++j) {
			map[nowY][nowX] = j;
			if (!check(nowX, nowY)) {
				map[nowY][nowX] = 0;
				continue;
			}
			func(n + 1, st + 1);
			map[nowY][nowX] = 0;
		}
	}

	private static boolean check(int x, int y) {
		int[] ch = new int[10];
		// h
		for (int i = 0; i < 9; ++i) {
			ch[map[y][i]]++;
			if (map[y][i] != 0 && ch[map[y][i]] > 1)
				return false;
		}
		// w
		Arrays.fill(ch, 0);
		for (int i = 0; i < 9; ++i) {
			ch[map[i][x]]++;
			if (map[i][x] != 0 && ch[map[i][x]] > 1)
				return false;
		}
		// rect
		Arrays.fill(ch, 0);
		for (int i = y / 3 * 3; i < y / 3 * 3 + 3; ++i) {
			for (int j = x / 3 * 3; j < x / 3 * 3 + 3; ++j) {
				ch[map[i][j]]++;
				if (map[i][j] != 0 && ch[map[i][j]] > 1)
					return false;
			}
		}
		return true;
	}
}
