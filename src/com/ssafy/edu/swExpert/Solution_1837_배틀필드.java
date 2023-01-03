package com.ssafy.edu.swExpert;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_1837_배틀필드 {
	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int W;
	static int H;
	static int x;
	static int y;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];

			int dir = 0;
			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				arr[i] = input.toCharArray();
				for (int j = 0; j < input.length(); ++j) {
					if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						x = j;
						y = i;
						switch (arr[i][j]) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 2;
							break;
						case '<':
							dir = 3;
							break;
						case '>':
							dir = 1;
							break;
						}
					}
				}
			}
			int N = Integer.parseInt((br.readLine()));
			String input = br.readLine();

			for (int i = 0; i < input.length(); ++i) {
				switch (input.charAt(i)) {
				case 'U':
					dir = 0;
					move(dir);
					break;
				case 'D':
					dir = 2;
					move(dir);
					break;
				case 'L':
					dir = 3;
					move(dir);
					break;
				case 'R':
					dir = 1;
					move(dir);
					break;
				case 'S':
					shoot(dir);
					break;
				}
			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; ++j) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

		}
	}

	private static void shoot(int dir) {
		int sx = x;
		int sy = y;
		while (true) {
			int nx = sx + dx[dir];
			int ny = sy + dy[dir];
			if (checkMap(ny, nx))// 맵 밖으로 이동 종료
				return;
			if (arr[ny][nx] == '*') {// 벽돌
				arr[ny][nx] = '.';
				return;
			} else if (arr[ny][nx] == '#')
				return;
			sx = nx;
			sy = ny;
		}
	}

	private static void move(int dir) {
		arr[y][x] = drawTank(y, x, dir);
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (checkMap(ny, nx))// 맵 밖으로 이동 불가 종료
			return;
		if (arr[ny][nx] != '.')
			return;
		arr[y][x] = '.';
		x = nx;
		y = ny;
		// 전차 이동후 지형 평지로 변경
		arr[y][x] = drawTank(y, x, dir);
	}

	private static boolean checkMap(int ny, int nx) {
		if (nx < 0 || nx >= W || ny < 0 || ny >= H)
			return true;
		return false;
	}

	private static char drawTank(int y, int x, int dir) {
		switch (dir) {
		case 0:
			return '^';
		case 1:
			return '>';
		case 2:
			return 'v';
		case 3:
			return '<';
		}
		return 0;
	}
}