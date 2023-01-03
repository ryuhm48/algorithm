package com.ssafy.edu.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

public class Main_813_b {
	static int answer;
	static int N;
	static int[] arr;
	static int K;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			answer = 0;
			for (int i = N - 1; i >= 1; i -= 2) {
				arr[i] = i;
				arr[i - 1] = i+1;
			}
			if (N % 2 == 1) {
				arr[0] = 1;
			}
			// start

			// end

			// 출력
			for (int i = 0; i < N; ++i)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}