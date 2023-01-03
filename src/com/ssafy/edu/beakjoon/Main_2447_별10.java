package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_2447_별10 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		func(0, 0, N);



		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sb.append(arr[i][j] == 1 ? "*" : " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

	private static void func(int r, int c, int n) {
		if (n == 1) {
			arr[r][c] = 1;
			return;
		}
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j) {
				if(i==1 &&j==1)continue;
				func(r+i*n/3,c+j*n/3,n/3);
			}
		}
	}

}
