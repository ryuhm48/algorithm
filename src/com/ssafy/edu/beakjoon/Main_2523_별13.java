package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_2523_별13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i 0 1 2 3 4
		// j 2 1 0 1 2 j= abs(i-N/2)-1
		// k 1 2 3 2 1 k= -abs(i-N)+N+1
		N = N * 2 - 1;
		for (int i = 0; i < N; ++i) {
//			for (int j = 0; j < Math.abs(i - N / 2) ; ++j) {
//				System.out.printf(" ");
//			}
			for (int j = 0; j < -Math.abs(i - N / 2) + N / 2 + 1; ++j) {
				System.out.printf("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
