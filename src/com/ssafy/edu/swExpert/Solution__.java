package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution__ {
	static int answer;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(br.readLine());
		Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
		}

		int T;
//		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력

			// start

			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					System.out.print(+" ");
				}
				System.out.println();
			}
		}
	}
}