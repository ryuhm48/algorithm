package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;

import com.ssafy.edu.beakjoon.Main_1194_달이차오른다가자.point;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9205_맥주마시면서걸어가기 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[][] map;
	static double[][] con;
	static int[] visit;
	static int T;
	static int N;
	static int answer;
	static final double M = (32767 + 32768) / 50;

	static class point {
		double x;
		double y;
		int beer;

		point(double x, double y, int beer) {
			this.x = x;
			this.y = y;
			this.beer = beer;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			// 입력
			N = Integer.parseInt(br.readLine());
			con = new double[N][2];
			visit = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			double hx = Integer.parseInt(st.nextToken());
			double hy = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			double fx = Integer.parseInt(st.nextToken());
			double fy = Integer.parseInt(st.nextToken());

			// start
			int flg = 0;
			Queue<point> q = new LinkedList<>();
			q.offer(new point(hx, hy, 20));

			while (!q.isEmpty()) {
				point now = q.poll();

				if (calcDis(now.x, now.y, fx, fy)) {
					flg = 1;
					break;
				}
				for (int i = 0; i < N; ++i) {
					if (visit[i] != 0)
						continue;
					if (calcDis(now.x, now.y, con[i][0], con[i][1])) {
						q.offer(new point(con[i][0], con[i][1], 20));
						visit[i] = 1;
					}
				}
			}
			// end

			// 출력
			String[] ans = { "sad", "happy" };
			System.out.println(ans[flg]);
		}

	}

	private static boolean calcDis(double x1, double y1, double x2, double y2) {
		if (Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 1000)
			return true;
		return false;
	}
}
