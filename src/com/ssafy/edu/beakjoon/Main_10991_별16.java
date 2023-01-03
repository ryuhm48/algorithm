package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_10991_별16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i 0 1 2 3 4
		// j 0 1 2 3 4 j=
		// k 0 1 3 5 7 k=
		// N = N;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - i - 1; ++j) {
				System.out.printf(" ");
			}
			System.out.printf("*");
			for (int j = 0; j < i; ++j) {
				System.out.printf(" *");
			}
			System.out.println();
			String a="";
			Character.isDigit(a.charAt(0));
		}
		sc.close();
	}

}
