package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		int flg = 0;
		int num = 0;
		char[] input2 = input.toCharArray();
		for (int i = 0; i < input2.length; ++i) {
			if ('0' <= input2[i] && input2[i] <= '9') {
				sb.append(input2[i]);
			} else {
				if (flg == 0) {
					num += Integer.parseInt(sb.toString());
				} else {
					num -= Integer.parseInt(sb.toString());
				}
				if (input2[i] == '-') {
					flg = 1;
				}
				sb.setLength(0);
//				list.add(Integer.valueOf(sb.toString()));
//				list2.add(input.charAt(i));
			}

		}
		if (flg == 0) {
			num += Integer.parseInt(sb.toString());
		} else {
			num -= Integer.parseInt(sb.toString());
		}
//		list.add(Integer.valueOf(sb.toString()));

//		for (int i = 0; i < list2.size(); ++i) {
//			if (list2.get(i) == '+') {
//				int fst = list.get(i);
//				int snd = list.get(i + 1);
//				list.remove(i + 1);
//				list.remove(i);
//				list.add(i, fst + snd);
//				list2.remove(i--);
//			}
//		}
//		int num = list.get(0);
//		for (int i = 1; i < list.size(); ++i) {
//			num -= list.get(i);
//		}
		// 1 2 3 4
		// + - +
		// 3 3 4
		// - +
		// start

		// end

		// 출력
		System.out.println(num);
	}
}
