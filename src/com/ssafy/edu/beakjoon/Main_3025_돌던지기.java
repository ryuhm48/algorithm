package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3025_돌던지기 {
	static int[] dr = { 1, 1, 1, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, -1, 1, -1, 1, -1, 1, -1 };
	static char[][] map;
	static Stack<Point>[] stack;
	static int R;
	static int C;
	static int N;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		stack = new Stack[C];
		for (int i = 0; i < C; ++i)
			stack[i] = new Stack<>();
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		// start
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			int input = Integer.parseInt(br.readLine());
			func(0, input);
		}
		// end

		// 출력
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(ㅁㄴㅇ);
		}
	}

	private static void func(int r, int c) {
		while (true) {
			while (!stack[c].isEmpty() && true) {

			}

		}
	}
}
