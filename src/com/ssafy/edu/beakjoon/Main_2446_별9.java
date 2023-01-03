package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_2446_별9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// i 0 1 2 3 4 5 6 7 8
		// j 9 7 5 3 1 3 5 7 9 j= abs(-2*i+N-1)+1
		// k 0 1 2 3 4 3 2 1 0 k= |i-N/2|-N/2
		//|-2(i-N/2)-1|+1
		N = N * 2 - 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < -Math.abs(i - N / 2) + N / 2; ++j) {
				System.out.printf(" ");
			}
			for (int j = 0; j < Math.abs(-2 * i + N - 1) + 1; ++j) {
				System.out.printf("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
