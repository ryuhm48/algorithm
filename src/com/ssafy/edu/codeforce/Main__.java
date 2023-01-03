package com.ssafy.edu.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

public class Main__ {
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
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			answer = 0;
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i]>K)answer++;
			}
			// start
			
			// end

			// 출력
			System.out.printf("%d\n", answer);
		}
	}
}