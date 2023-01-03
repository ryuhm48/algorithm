package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int[][] map;
	static int[][] visit;
	static int R;
	static int[] dr = { -1, 0, 1 };
	static int C;
	static int answer = 0;
	static int check = 0;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visit = new int[R][C];
		for (int i = 0; i < R; ++i) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				if (arr[j] == '.')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}

		// start
		answer = 0;
		for (int i = 0; i < R; ++i) {
			check = 0;
			func(i, 0);
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func(int r, int c) {
		visit[r][c] = 1;
		if (c == C - 1) {
			answer++;
			check = 1;
			return;
		}
		for (int dir = 0; dir < 3; ++dir) {
			int nc = c + 1;
			int nr = r + dr[dir];
			if (nr < 0 || nr >= R)
				continue;
			if (visit[nr][nc] == 1 || map[nr][nc] == 1)
				continue;
			func(nr, nc);
			if (check == 1)
				return;
		}
	}
}
