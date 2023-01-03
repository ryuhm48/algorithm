package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17143_낚시왕 {
	static int[] dx = { 0, 0, 0, 1, -1, 1, -1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0, -1, 1, -1 };
	static List<shark> list;
	static int[][] map;
	static int[] isAlive;
	static int R;
	static int C;
	static int M;
	static int answer;

	static class shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		list = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new shark(r, c, s, d, z));
			map[r][c] = i + 1;
		}
		isAlive = new int[list.size()];

		// start
		func();
		// end

		// 출력
		System.out.println(answer);
	}

	private static void func() {
		for (int i = 0; i < C; ++i) {
			fishing(i);
			move();
		}
	}

	private static void move() {
		int[][] tmp = new int[R][C];
		for (int i = 0; i < list.size(); ++i) {
			if (isAlive[i] != 0)
				continue;
			shark now = list.get(i);
			int tmpS = now.s;
			int x = now.c;
			int y = now.r;
			int dir = now.d;
			if (dir == 3 || dir == 4) {
				int nx = x + (dx[dir] * tmpS);
				while (!(nx >= 0 && nx < C)) {
					if (nx < 0) {
						nx = Math.abs(nx);
						dir = 3;
					}
					if (nx >= C) {
						nx = C - 1 - (nx - C + 1);
						dir = 4;
					}
				}
				x = nx;
			}
			if (dir == 1 || dir == 2) {
				int ny = y + (dy[dir] * tmpS);
				while (!(ny >= 0 && ny < R)) {
					if (ny < 0) {
						ny = Math.abs(ny);
						dir = 2;
					}
					if (ny >= R) {
						ny = R - 1 - (ny - R + 1);
						dir = 1;
					}
				}
				y = ny;
			}
//			while (tmpS-- > 0) {
//				int nx = x + dx[dir];
//				int ny = y + dy[dir];
//				if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
//					dir++;
//					if (dir == 3 || dir == 5)
//						dir -= 2;
//					nx = x + dx[dir];
//					ny = y + dy[dir];
//				}
//				x = nx;
//				y = ny;
//			}
			now.c = x;
			now.r = y;
			now.d = dir;
			if (tmp[y][x] != 0) {
				shark scd = list.get(tmp[y][x] - 1);
				if (now.z < scd.z) {
					isAlive[i] = 1;
					continue;
				} else {
					isAlive[tmp[y][x] - 1] = 1;
				}
			}
			tmp[y][x] = i + 1;
		}
		map = tmp;
	}

	private static void fishing(int idx) {
		for (int i = 0; i < R; ++i) {
			if (map[i][idx] != 0) {
				int num = map[i][idx];
				answer += list.get(num - 1).z;
//				list.remove(num);
				isAlive[num - 1] = 1;
				map[i][idx] = 0;
				return;
			}
		}
	}
}
