package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17144_미세먼지안녕 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<Point> dust;
	static int[][] map;
	static int[] arr;
	static int T;
	static int R;
	static int C;
	static int answer;
	static Point air;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dust = new ArrayList<>();
		air = new Point(0, 0);
		int flg = 0;
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && flg == 0) {
					flg = 1;
					air.x = j;
					air.y = i;
				} else if (map[i][j] != 0 && map[i][j] != -1) {
					dust.add(new Point(j, i));
				}
			}
		}
		// start
		func();

		// end

		// 출력
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] > 0)
					answer += map[i][j];
			}
		}
		System.out.println(answer);
	}

	private static void func() {
		while (T-- > 0) {
			// 4방향 확산 청정확산x
			dustDiffusion();
//			print();
			// 공기청정
			airDiffusion();
//			print();
			dust.clear();
			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					if (map[i][j] > 0)
						dust.add(new Point(j, i));
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------a");

	}

	private static void airDiffusion() {
		// up
		moveDust(air.y, air.x, 0);
		// down
		moveDust(air.y + 1, air.x, 1);
	}

	private static void moveDust(int y, int x, int flg) {
		// u r d l
		if (flg == 0) {
			moveUp(0, x, y - 1);
			moveRight(0, x);
			moveDown(0, C - 1, y);
			moveLeft(y, x);
			map[y][x + 1] = 0;
		} else {
			moveDown(y + 1, 0, R - 1);
			moveRight(R - 1, x);
			moveUp(y, C - 1, R - 1);
			moveLeft(y, x);
			map[y][x + 1] = 0;
		}
		// d l r u
	}

	private static void moveLeft(int y, int x) {
		for (int i = C - 2; i > 0; --i) {
			map[y][i + 1] = map[y][i];
		}
	}

	private static void moveDown(int y1, int x1, int y2) {
		for (int i = y1 + 1; i <= y2; ++i) {
			map[i - 1][x1] = map[i][x1];
		}
	}

	private static void moveRight(int y, int x) {
		for (int i = 1; i < C; ++i) {
			map[y][i - 1] = map[y][i];
		}
	}

	private static void moveUp(int y1, int x, int y2) {
		for (int i = y2 - 1; i >= y1; --i) {
			map[i + 1][x] = map[i][x];
		}
	}

	private static void dustDiffusion() {
		int[][] tmpMap = new int[R][C];
		tmpMap[air.y][air.x] = -1;
		tmpMap[air.y + 1][air.x] = -1;

//		for (int i = 0; i < R; ++i)
//			System.arraycopy(map, 0, tmpMap, 0, C);
		for (Point d : dust) {

			int x = d.x;
			int y = d.y;
			int dirCnt = 0;
			int nowDust = map[y][x];
//			if (nowDust < 5) {
//				tmpMap[y][x] = nowDust;
//				continue;
//			}
			for (int dir = 0; dir < 4; ++dir) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || nx >= C || ny < 0 || ny >= R)
					continue;
				if (map[ny][nx] == -1)
					continue;
				dirCnt++;
				tmpMap[ny][nx] += nowDust / 5;
			}
			tmpMap[y][x] += nowDust - (nowDust / 5 * dirCnt);
		}

		map = tmpMap;
	}
}
