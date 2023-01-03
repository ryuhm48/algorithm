package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2110_공유기설치 {
	static int[] arr;
	static int N;
	static int C;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// start
		Arrays.sort(arr);
		int l = 0;
		int r = 1000000000;
		answer = 0;
		// 이분탐색
		while (l <= r) {
			int mid = (l + r) / 2;
			int flg = 1;

			int pre = 0;
			int now = 1;
			// 1번집부터 시작해서 mid보다 가까우면 flg=0
			for (int i = 1; i < C; ++i) {
				while (now < N && arr[now] - arr[pre] < mid) {
					now++;
				}
				if (now == N) {
					flg = 0;
					break;
				} else {
					pre = now;
					now++;
				}
			}
			if (flg == 1) {
				// 와이파이가 mid보다 떨어져있음
				answer = Math.max(answer, mid);
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		// end

		// 출력
		System.out.println(answer);
	}
}
