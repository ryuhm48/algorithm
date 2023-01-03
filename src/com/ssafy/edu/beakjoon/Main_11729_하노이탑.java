package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11729_하노이탑 {
	static int N;
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cnt = 0;
		hanoi(N);
		System.out.println(cnt);
		System.out.println(sb.toString());
		br.close();
	}

	static void hanoi(int n) {

		hanoi(n, 1, 3, 2);
	}

	private static void hanoi(int n, int a, int b, int c) {
		cnt++;
		if (n == 1) {
			sb.append(a + " " + b + "\n");
			return;
		}
		hanoi(n - 1, a, c, b);
		sb.append(a + " " + b + "\n");
		hanoi(n - 1, c, b, a);
	}
}
