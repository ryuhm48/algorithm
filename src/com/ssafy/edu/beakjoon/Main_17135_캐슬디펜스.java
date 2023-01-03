package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17135_캐슬디펜스 {
	static List<Integer> ac;
	static int[][] map;
	static int[] comb;
	static int N;
	static int M;
	static int D;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int enermy = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enermy++;
			}
		}
		// start
		int answer = 0;
		comb = new int[M];
		for (int i = M - 3; i < M; ++i) {
			comb[i] = 1;
		}
		do {
			int mx = 0;
			ac = new ArrayList<>();
			// 궁수 위치 지정
			for (int i = 0; i < M; ++i) {
				if (comb[i] == 1) {
					ac.add(i);
				}
			}
			int[][] tmp = new int[N][M];
			for (int i = 0; i < N; ++i)
				System.arraycopy(map[i], 0, tmp[i], 0, M);
			// 모든 적이 격자판에서 제거 될때까지 반복
			int cnt = enermy;
			while (cnt > 0) {
				int num = attack(tmp, cnt);
				cnt -= num;
				mx += num;
				cnt -= move(tmp, cnt);
			}
			if (mx > answer)
				answer = mx;
		} while (np(M - 1));
		// end

		// 출력
		System.out.println(answer);
	}

	private static int move(int[][] tmp, int cnt) {
		int ret = 0;
		for (int i = N - 1; i >= 0; --i) {
			for (int j = 0; j < M; ++j) {
				if (i == N - 1 & tmp[i][j] == 1) {
					ret++;
					tmp[i][j] = 0;
					cnt--;
				}
				if (tmp[i][j] == 1) {
					tmp[i + 1][j] = 1;
					tmp[i][j] = 0;
					cnt--;
				}
				if (cnt == 0)
					break;
			}
			if (cnt == 0)
				break;
		}
		return ret;
	}

	private static int attack(int[][] tmp, int cnt) {
		int ret = 0;
		List<Point> enermy = new ArrayList<>();
		List<Point> target = new ArrayList<>();
		for (int i = N - 1; i >= 0; --i) {
			for (int j = 0; j < M; ++j) {
				if (tmp[i][j] == 1) {
					enermy.add(new Point(j, i));
					cnt--;
				}
				if (cnt == 0)
					break;
			}
			if (cnt == 0)
				break;
		}
		for (int acX : ac) {
			int acY = N;
			int targetDis = D;
			Point targetLoc = new Point(M, N);
			for (Point loc : enermy) {
				int dis = calc(new Point(acX, acY), loc);
				if (dis <= targetDis) {
					if (dis == targetDis && loc.x > targetLoc.x) {
						continue;
					}
					targetLoc = loc;
					targetDis = dis;
				}
			}
			if (targetLoc.x != M && targetLoc.y != N)
				target.add(targetLoc);
		}
		for (Point t : target) {
			if (tmp[t.y][t.x] == 1) {
				ret++;
			}
			tmp[t.y][t.x] = 0;
		}
		return ret;

	}

	private static int calc(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
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
		while (i <= k) {
			tmp = comb[k];
			comb[k--] = comb[i];
			comb[i++] = tmp;
		}
		return true;
	}
}
