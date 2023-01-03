package com.ssafy.edu.beakjoon;

import java.util.Scanner;

public class Main_10972_다음순열 {

	static int[] p;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		p = new int[N];
		for (int i = 0; i < N; ++i) {
			p[i] = sc.nextInt();
		}
		if(np(N - 1)) {
			for(int i=0;i<N;++i) {
				System.out.printf("%d ",p[i]);
			}
			System.out.println();
		}
		else {
			System.out.println(-1);
		}
	}

	private static boolean np(int size) {
		// find peak
		int i = size;
		while (i > 0 && p[i - 1] > p[i])
			i--;
		if (i == 0)
			return false;

		// swap(i-1,j)
		int j = size;
		while (p[i - 1] > p[j])
			j--;
		int tmp = p[j];
		p[j] = p[i - 1];
		p[i - 1] = tmp;

		// reverse(i,k)
		int k = size;
		while (i < k) {
			tmp = p[k];
			p[k] = p[i];
			p[i] = tmp;
			i++;
			k--;
		}
		return true;
	}

}
