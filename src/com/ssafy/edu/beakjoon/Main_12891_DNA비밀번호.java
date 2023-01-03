package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	static int[] arr;
	static int[][] visit;
	static int N;
	static int M;
	static int V;
	static int S;
	static int P;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[] alpha = { 'A', 'C', 'G', 'T' };
	static Map<Character, Integer> m = new HashMap<>();
	static int[] nums;
	static int ans;
	static String input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		input = br.readLine();
		st = new StringTokenizer(br.readLine());
		arr = new int[4];
		nums = new int[4];
		int cnt = 0;
		for (int i = 0; i < 4; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			m.put(alpha[i], cnt++);
		}

		func(0, 0);
//		cnt = 0;
//		for (int i = 0; i < S; ++i) {
//			if (cnt == P) {
//				if (check())
//					ans++;
//				nums[m.get(input.charAt(i - P))]--;
//				cnt--;
//			}
//			nums[m.get(input.charAt(i))]++;
//			cnt++;
//		}
//		if (check())
//			ans++;

		System.out.println(ans);
	}

	private static void func(int n, int st) {
		if (n == P) {
			int[] cnt = new int[4];
			for (int i = 0; i < P; ++i) {
				int tmp = m.get(nums[i]);
				cnt[tmp]++;
			}
			for (int i = 0; i < 4; ++i) {
				if (cnt[i] < arr[i])
					return;

			}
			ans++;
			return;
		}
		nums[n] = input.charAt(st);
		func(n + 1, st + 1);
	}

	private static boolean check() {
		for (int j = 0; j < 4; ++j) {
			if (nums[j] < arr[j]) {
				return false;
			}
		}
		return true;
	}

}
