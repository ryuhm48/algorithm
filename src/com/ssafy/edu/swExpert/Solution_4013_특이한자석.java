package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_4013_특이한자석 {
	static int answer;
	static int K;
	static int[][] arr;
	static int[] canRotate;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			K = Integer.parseInt(br.readLine());
			arr = new int[4][8];
			canRotate = new int[4];
			for (int i = 0; i < 4; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				func(num - 1, dir);
			}
			// start
			answer = 0;
			int ans = 1;
			for (int i = 0; i < 4; ++i, ans *= 2)
				answer += ans * arr[i][0];
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	private static void func(int num, int dir) {
		findCanRotate(num);
		rotateAll(num, dir);
	}

	private static void rotateAll(int num, int dir) {
		int nowDir = dir;
		for (int i = num; i >= 0; --i) {
			if (canRotate[i] == 1) {
				rotate(i, nowDir);
				nowDir *= -1;
			}
		}
		nowDir = dir * -1;
		for (int i = num + 1; i < 4; ++i) {
			if (canRotate[i] == 1) {
				rotate(i, nowDir);
				nowDir *= -1;
			}
		}
	}

	private static void rotate(int num, int nowDir) {
		if (nowDir == 1) {// 시계방향
			int tmp = arr[num][7];
			for (int i = 7; i > 0; --i)
				arr[num][i] = arr[num][i - 1];
			arr[num][0] = tmp;
		} else {
			int tmp = arr[num][0];
			for (int i = 0; i < 7; ++i)
				arr[num][i] = arr[num][i + 1];
			arr[num][7] = tmp;
		}
	}

	private static void findCanRotate(int num) {
		for (int i = 0; i < 4; ++i)
			canRotate[i] = 0;
		canRotate[num] = 1;
		for (int i = num; i > 0; --i) {
			if (arr[i][6] != arr[i - 1][2]) {
				canRotate[i - 1] = 1;
			} else {
				canRotate[i - 1] = 0;
				break;
			}
		}
		for (int i = num; i < 3; ++i) {
			if (arr[i][2] != arr[i + 1][6]) {
				canRotate[i + 1] = 1;
			} else {
				canRotate[i + 1] = 0;
				break;
			}
		}
	}
}