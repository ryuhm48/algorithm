package com.ssafy.edu.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_16637_괄호추가하기 {
//	static int[][] arr;
	static int[][] visit;
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int mx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int answer = 0;
		// 9 0 2 4 6 N-1
		// 기본 값
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length; i += 2) {

			String pre = "";
			if (i != 0)
				pre = input.substring(0, 0 + i);
			String next = "";
			if (i < input.length() - 2)
				next = input.substring(i + 3);
			String now = calc(input.substring(i, i + 2));

			char calc = input.charAt(i + 1);
			int snd = input.charAt(i + 2) - '0';
			String cs = pre + now + next;
		}
		//0 1 2 3 4 
		//0 1 2 3
		System.out.println(answer);
	}

	private static String calc(String substring) {
		int fst = substring.charAt(0) - '0';
		char calc = substring.charAt(1);
		int snd = substring.charAt(2) - '0';
		int ret = 0;
		switch (calc) {
		case '+':
			ret = fst + snd;
			break;
		case '-':
			ret = fst - snd;
			break;
		case '*':
			ret = fst * snd;
			break;
		}
		return String.valueOf(ret);
	}
}
