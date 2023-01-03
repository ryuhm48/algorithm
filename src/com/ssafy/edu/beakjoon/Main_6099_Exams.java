package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6099_Exams {
	static List<Long> list;
	static List<Long> list2;
	static long[] arr;
	static int[] visit;
	static int N;
	static long T;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new long[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		// start
		long answer = 0L;
		Arrays.sort(arr);
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		visit = new int[N];
		func(0, 0, arr.length / 2);
		func2(0, arr.length / 2, arr.length - arr.length / 2);
		Collections.sort(list);
		Collections.sort(list2);

		for (int i = 0; i < list.size(); ++i) {
			long num1 = list.get(i);
			answer += list2.size() - lowerBound(T - num1);
		}
		// end

		// 출력
		System.out.println(answer);
	}

	private static int lowerBound(long target) {
		int l = 0;
		int r = list2.size();
		while (l < r) {
			int mid = (l + r) / 2;
			long num2 = list2.get(mid);
			if (num2 < target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return r;
	}

	private static void func2(int n, int idx, int sz) {
		if (n == sz) {
			long sum = 0L;
			for (int i = 0; i < N; ++i) {
				if (visit[i] == 1) {
					sum += arr[i];
				}
			}
			list2.add(sum);
			return;
		}

		visit[idx] = 1;
		func2(n + 1, idx + 1, sz);
		visit[idx] = 0;
		func2(n + 1, idx + 1, sz);
	}

	private static void func(int n, int idx, int sz) {
		if (n == sz) {
			long sum = 0L;
			for (int i = 0; i < N; ++i) {
				if (visit[i] == 1) {
					sum += arr[i];
				}
			}
			list.add(sum);
			return;
		}

		visit[idx] = 1;
		func(n + 1, idx + 1, sz);
		visit[idx] = 0;
		func(n + 1, idx + 1, sz);
	}
}
