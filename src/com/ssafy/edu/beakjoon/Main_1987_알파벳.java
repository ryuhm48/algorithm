package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1987_알파벳 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int R;
	static int C;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new int[26];
		for (int i = 0; i < R; ++i) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				map[i][j] = input[j] - 'A';
			}
		}
		// start
		visit[map[0][0]] = 1;
		func(0, 0, 1);
		// end

		// 출력
		System.out.println(cnt);
	}

	private static void func(int r, int c, int dep) {

		if (dep > cnt)
			cnt = dep;
		for (int dir = 0; dir < 4; ++dir) {
			int nr = r + dy[dir];
			int nc = c + dx[dir];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (visit[map[nr][nc]] != 0)
				continue;
			visit[map[nr][nc]] = 1;
			func(nr, nc, dep + 1);
			visit[map[nr][nc]] = 0;

		}
	}
}
