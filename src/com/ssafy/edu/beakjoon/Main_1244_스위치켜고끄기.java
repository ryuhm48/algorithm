package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] gender = new int[M];
		int[] sw = new int[M];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			gender[i] = Integer.parseInt(st.nextToken());
			sw[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; ++i) {
			if (gender[i] == 1) {
				changeMan(sw[i]);
			} else {
				changeWoman(sw[i]);
			}
		}
		//출력
		for (int i = 1; i < arr.length; ++i) {
			System.out.printf("%d ", arr[i]);
			if (i % 20 == 0)
				System.out.println();
		}
		br.close();
	}

	private static void changeWoman(int i) {
		arr[i] = (arr[i] + 1) % 2;
		int p = i - 1;
		int n = i + 1;
		while (true) {
			if (p < 1 || p > N || n < 1 || n > N) // 범위초과
				break;
			if (arr[p] != arr[n])// 대칭이 아님
				break;
			arr[p] = (arr[p] + 1) % 2;
			arr[n] = (arr[n] + 1) % 2;
			p--;
			n++;
		}

	}

	private static void changeMan(int j) {
		int num = j;
		while (num <= N) {
			arr[num] = (arr[num] + 1) % 2;
			num += j;
		}
	}
}
