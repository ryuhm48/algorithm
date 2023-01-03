package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1759_암호만들기 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static char[] arr;
	static char[] vow = { 'a', 'e', 'i', 'o', 'u' };
	static int L;
	static int C;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; ++i) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		func(0, 0, 0, 0, "");
		// start

		// end

		// 출력
	}

	private static void func(int n, int st, int vo, int con, String ans) {
		if (n == L) {
			if (vo < 1 || con < 2) {
				return;
			}
			System.out.println(ans);
			return;
		}
		for (int i = st; i < C; ++i) {
			String tmp = ans;
			int tmpVo = vo;
			int tmpCon = con;
			for (int j = 0; j < vow.length; ++j) {
				if (vow[j] == arr[i]) {
					tmpVo++;
				}
			}
			if (tmpVo == vo)
				tmpCon++;
			tmp += arr[i];
			func(n + 1, i + 1, tmpVo, tmpCon, tmp);
		}
	}
}
