package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_2445_별9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i 0 1 2 3 4 5 6 7 8
		// j 1 2 3 4 5 4 3 2 1 j= -abs(i-N)
		// k 4 3 2 1 0 1 2 3 4 k= abs(i-N/2)
		//
		N = N * 2 - 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < -Math.abs(i + N / 2) + N / 2 + 1; ++j) {
				System.out.printf("*");
			}
			for (int j = 0; j < 2 * Math.abs(i - N / 2); ++j) {
				System.out.printf(" ");
			}
			for (int j = 0; j < -Math.abs(i + N / 2) + N / 2 + 1; ++j) {
				System.out.printf("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
