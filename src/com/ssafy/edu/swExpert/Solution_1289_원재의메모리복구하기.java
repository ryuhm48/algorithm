package com.ssafy.edu.swExpert;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			String input = br.readLine();

			// 이전비트와 지금비트가 다르면 ++
			// if(1) preflg=1 ch++
			// if(flg)ch++
			//
			int pre = 0;
			for (int i = 0; i < input.length(); ++i) {
				int now = input.charAt(i) - '0';
				if (pre == 1 && now == 0) {
					answer++;
					pre = 0;
				}
				else if (pre == 0 && now == 1) {
					answer++;
					pre = 1;
				}
			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}