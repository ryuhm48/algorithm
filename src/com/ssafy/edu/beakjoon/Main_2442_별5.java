package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2442_별5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0 1 2 3 4
		// 1 3 5 7 9 j = i*2+1
		// 4 3 2 1 0 k = N-i-1
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - i - 1; ++j) {
				System.out.printf(" ");
			}
			for (int j = 0; j < i * 2 + 1; ++j) {
				System.out.printf("*");
			}
			System.out.println();
		}

	}

}
