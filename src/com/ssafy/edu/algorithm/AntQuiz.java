package com.ssafy.edu.algorithm;

import java.util.Scanner;

public class AntQuiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(ant(s));
	}

	public static void ant(int stage) {
		String s = "11";
		for (int i = 0; i < stage; ++i) {
			System.out.println(s);
			s = ant(s);
		}
		System.out.println(s);
	}

	public static String ant(String s) {
		String ret = "";
		char c = s.charAt(0);
		int cnt = 1;
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == c) {
				cnt++;
			} else {
				ret = ret + c + cnt;
//				ret = ret + String.valueOf(cnt);
				c = s.charAt(i);
				cnt = 1;
			}
		}
		ret = ret + c + cnt;
		return ret;
	}

}
