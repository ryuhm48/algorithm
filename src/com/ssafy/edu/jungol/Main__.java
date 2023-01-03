package com.ssafy.edu.jungol;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main__ {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(br.readLine());
		Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
		}

		// start

		// end

		// 출력
		System.out.println();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(+" ");
			}
			System.out.println();
		}
	}
}
