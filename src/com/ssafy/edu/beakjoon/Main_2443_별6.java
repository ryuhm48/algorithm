package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2443_별6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0 1 2 3 4
		// 9 7 5 3 1 j = -i*2+9
		// 0 1 2 3 4 k = N-i-1
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				System.out.printf(" ");
			}
			for (int j = 0; j < -i * 2 + 2 * N - 1; ++j) {
				System.out.printf("*");
			}
			System.out.println();
		}

	}

}
