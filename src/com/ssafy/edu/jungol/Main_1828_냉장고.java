package com.ssafy.edu.jungol;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	static List<p> list;
	static int[][] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int cnt;

	static class p implements Comparable<p> {
		int low;
		int high;

		p(int low, int high) {
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(p o) {
			if (low == o.low)
				return Integer.compare(high, o.high);
			return Integer.compare(low, o.low);
		}

	}

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<p>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new p(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// start
		int answer = 1;
		list.sort(null);
		// end
		int stLow = list.get(0).low;
		int stHigh = list.get(0).high;
		for (int i = 1; i < list.size(); ++i) {
			p now = list.get(i);
			if (now.low > stHigh) {
				answer++;
				stLow = now.low;
				stHigh = now.high;
				continue;
			}
			stHigh = Math.min(stHigh, now.high);
			stLow = Math.max(stLow, now.low);
		}
		// 출력
		System.out.println(answer);
	}
}
