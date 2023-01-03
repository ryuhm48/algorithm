package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		npr(0, "");

		isP(N);
		System.out.println("\n" + cnt);
	}

	private static void npr(int n, String num) {
		if (n == N) {
			System.out.println(num);
			cnt++;
			return;
		}

		for (int i = 1; i < 10; ++i) {
			if (N != 1 && n == N - 1 && i % 2 == 0)
				continue;
			String tmp = num + i;
			if (isP(Integer.valueOf(tmp)) == false)
				continue;

			npr(n + 1, tmp);
		}
	}

	private static boolean isP(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
