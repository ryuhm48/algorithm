package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_test_낚시터자리잡기 {
	// n 60
	// enter 3
	// angler 20
	static int answer;
	static int N;
	static int[] check;
	static int[] enter;
	static int[] angler;
	static int[] arr;

	static int[] dx = { -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			enter = new int[3];
			angler = new int[3];
			check = new int[3];
			arr = new int[3];
			for (int i = 0; i < 3; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				enter[i] = Integer.parseInt(st.nextToken()) - 1;
				angler[i] = Integer.parseInt(st.nextToken());
			}
			// start
			answer = Integer.MAX_VALUE;
			func(0, new int[N], 0);
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int n, int[] fishing, int sum) {
		if (n == 3) {
			answer = Math.min(answer, sum);
//			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < 3; ++i) {
			if (check[i] == 1)
				continue;
			check[i] = 1;
			arr[n] = i;
			fillAngler(n, i, fishing, sum);
			check[i] = 0;
		}
	}

	private static void fillAngler(int n, int idx, int[] fishing, int sum) {
		int[] tmpFishing = new int[N];
		System.arraycopy(fishing, 0, tmpFishing, 0, N);
		int i;
		int now = enter[idx];
		int tmpSum = sum;
		for (i = 0; i < angler[idx] - 1; ++i) {// 배치 마지막 경우의 수 나눔
			Point mn1 = findLeftMn(now, tmpFishing);
			Point mn2 = findRightMn(now, tmpFishing);
			if (mn1.y < mn2.y) {
				tmpFishing[mn1.x] = 1;
				tmpSum += mn1.y;
			} else {
				tmpFishing[mn2.x] = 1;
				tmpSum += mn2.y;
			}
		}

		Point mn1 = findLeftMn(now, tmpFishing);
		Point mn2 = findRightMn(now, tmpFishing);
		if (mn1.y == mn2.y && mn1.y != 0) {// 마지막이 같다면 둘다 재귀 && 자기위치인경우는 제외
			tmpFishing[mn1.x] = 1;
			tmpSum += mn1.y;
			func(n + 1, tmpFishing, tmpSum);
			tmpFishing[mn1.x] = 0;
			tmpSum -= mn1.y;
			
			tmpFishing[mn2.x] = 1;			
			tmpSum += mn2.y;
			func(n + 1, tmpFishing, tmpSum);
		} else {// 마지막이 다르면 작은경우 재귀
			if (mn1.y < mn2.y) {
				tmpFishing[mn1.x] = 1;
				tmpSum += mn1.y;
			} else {
				tmpFishing[mn2.x] = 1;
				tmpSum += mn2.y;
			}
			func(n + 1, tmpFishing, tmpSum);
		}

	}

	private static Point findRightMn(int now, int[] tmpFishing) {
		int next = now;
		int dis = 1;
		while (next < N - 1 && tmpFishing[next] != 0) {
			next++;
			dis++;
		}
		if (tmpFishing[next] != 0)
			dis = Integer.MAX_VALUE;
		return new Point(next, dis);
	}

	private static Point findLeftMn(int now, int[] tmpFishing) {
		int next = now;
		int dis = 1;
		while (next > 0 && tmpFishing[next] != 0) {
			next--;
			dis++;
		}
		if (tmpFishing[next] != 0)
			dis = Integer.MAX_VALUE;
		return new Point(next, dis);
	}
}