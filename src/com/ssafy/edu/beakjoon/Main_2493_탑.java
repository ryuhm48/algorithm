package com.ssafy.edu.beakjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	static int[] arr;
	static int[][] visit;
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Stack<Point> s;
	static Stack<Point> s2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = new Stack<>();
		s2 = new Stack<>();
		for (int i = 0; i < N; ++i) {
			s.push(new Point(Integer.parseInt(st.nextToken()), i));
		}
		Point tmp = s.pop();
		s2.push(tmp);
		int pre = tmp.x;
		int[] arr = new int[N];
		while (!s.empty()) {
			Point now = s.pop();
			if (pre <= now.x) {// 크기가 큼 배열에 저장
				while (!s2.isEmpty()) {
					Point now2 = s2.pop();
					if (now2.x > now.x) {
						s2.push(now2);
						break;
					}
					arr[now2.y] = now.y + 1;
				}
			}
			s2.push(now);
			pre = now.x;
		}
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
