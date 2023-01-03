package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_1233_사칙연산유효성검사 {
	static char[] arr;
	static int[][] child;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int answer = 0;
	static int flg;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
//		T = Integer.parseInt(br.readLine());
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N+1];
			child = new int[N+1][2];
			for (int i = 0; i < N; ++i)
				Arrays.fill(child[i], -1);
			flg = 1;
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				arr[num] = st.nextToken().charAt(0);
//				System.out.println(num+" "+arr[num]);
				if (st.countTokens() > 1) {
					child[num][0] = Integer.parseInt(st.nextToken());
					child[num][1] = Integer.parseInt(st.nextToken());
				} else {
					if (!(arr[num] >= '0' && arr[num] <= '9')) {// 끝노드가 연산일시 불가
						flg = 0;
					}
				}
			}
			func(1);
			System.out.printf("#%d %d\n", test_case, flg);
		}
	}

	// 트리 탐색
	private static int func(int p) {
		int lf = 0;
		int rf = 0;
		int calc;
		if (child[p][0] != -1) {
			lf = func(child[p][0]);
		}
		if (child[p][1] != -1) {
			rf = func(child[p][0]);
		}
		
		if (lf == 1 && rf == 1) {// 자식이 모두 숫자
			switch (arr[p]) {
			case '+':
				calc = 1;
				break;
			case '-':
				calc = 1;
				break;
			case '*':
				calc = 1;
				break;
			case '/':
				calc = 1;
				break;
			default:// 유효x
				calc = 0;
				break;
			}
		} else if (lf == 1 || rf == 1) {// 하나만 숫자 유효x
			calc = 0;
		} else {// 자식없음 자신이 숫자여야함
			switch (arr[p]) {
			case '+':
				calc = 0;
				break;
			case '-':
				calc = 0;
				break;
			case '*':
				calc = 0;
				break;
			case '/':
				calc = 0;
				break;
			default:// 유효
				calc = 1;
				break;
			}
		}

		return calc;
	}
}