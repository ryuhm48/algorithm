package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2792_보석상자 {
	static long[] arr;
	static long N;
	static int M;
	static long answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[M];
		long mx = 0;
		for (int i = 0; i < M; ++i) {
			arr[i] = Long.parseLong(br.readLine());
			mx = Math.max(arr[i], mx);
		}

		// start
		long l = 1;
		long r = mx;
		while (l <= r) {
			long mid = (l + r) / 2;
			long sum = 0;
			for (int i = 0; i < M; ++i) {
				sum += arr[i] / mid;
				if (arr[i] % mid != 0)
					sum++;
			}
			if (sum > N) {
				l = mid + 1;
			} else {
				r = mid - 1;
				answer = mid;
			}

		}

		// end

		// 출력
		System.out.println(answer);
	}
}