package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1074_Z {
	static int r;
	static int c;
	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		// start
		func(0, 0, N);
		// end

		// 출력
	}

	private static void func(int y, int x, int n) {
		if (n == 1) {
			if (y == r && x == c) {
				System.out.println(cnt);
			}
			cnt++;
			return;
		}

		if (y + n / 2 > r && x + n / 2 > c) {
			func(y, x, n / 2);
		} else if (y + n / 2 > r && x + n / 2 <= c) {
			cnt += n * n / 4;
			func(y, x + n / 2, n / 2);
		} else if (y + n / 2 <= r && x + n / 2 > c) {
			cnt += n * n / 2;
			func(y + n / 2, x, n / 2);
		} else {
			cnt += n * n / 4 * 3;
			func(y + n / 2, x + n / 2, n / 2);
		}
	}
}
