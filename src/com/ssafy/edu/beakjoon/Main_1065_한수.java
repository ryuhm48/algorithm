package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_1065_한수 {

	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1 2 3 4 5 6 7 8 9
		// 11 12 13 14...
		// 22 23 24...
		// 111 123

		// 222 234
		// 자리수 나누기 후 for문 차이 계산
		arr = new int[1001];
		for (int i = 1; i < 100; ++i) {
			arr[i] = i;
		}
		isHansu(N, N);
		System.out.println(arr[N]);
	}

	private static void isHansu(int n, int N) {
		if (arr[n] != 0)
			return;

		isHansu(n - 1, N);

		String tmp = String.valueOf(n);
		char[] tmpC = tmp.toCharArray();
		int flg = 1;
		int d = tmpC[1] - tmpC[0];
		for (int i = 2; i < tmpC.length; ++i) {
			int tmpD = tmpC[i] - tmpC[i - 1];
			if (d != tmpD) {
				flg = 0;
				break;
			}
		}

		arr[n] = arr[n - 1];
		if (flg == 1) {
			arr[n]++;
		}
	}

}
