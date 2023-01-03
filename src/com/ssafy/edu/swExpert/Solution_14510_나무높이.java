package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_14510_나무높이 {
	static int answer;
	static int N;
	static int mx;
	static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			mx = 0;
			PriorityQueue<Integer> even = new PriorityQueue<>();
			PriorityQueue<Integer> odd = new PriorityQueue<>((x, y) -> {
				return Integer.compare(y, x);
			});
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, arr[i]);
			}
			for (int i = 0; i < N; ++i) {
				if (mx - arr[i] == 0)
					continue;
				if ((mx - arr[i]) % 2 == 0)
					even.add(mx - arr[i]);
				else
					odd.add(mx - arr[i]);
			}

			// start
			// 홀수 - 물을 준다 기다린다
			// 짝수 - 물을 준다 기다린다
			int day = 0;
			while (!even.isEmpty() || !odd.isEmpty()) {
				int flg = 0;
				while (!even.isEmpty() && !odd.isEmpty()) {
					day += 2;
					int e = even.poll();
					int o = odd.poll();
					e -= 2;
					o -= 1;
					if (e != 0)
						even.offer(e);
					if (o != 0)
						even.add(o);
				}
				while (!even.isEmpty()) {
					day++;
					int now = even.poll();
					if (day % 2 == 0) {
						now -= 2;
						if (now == 0)
							continue;
						even.offer(now);
					} else {
						if (now != 2 || even.size() > 0) {
							now -= 1;
							odd.offer(now);
							flg = 1;
							break;
						} else {
							even.offer(now);
						}
					}
				}
				if (flg == 1)
					continue;
				while (!odd.isEmpty()) {
					day++;
					int now = odd.poll();
					if (day % 2 == 0) {
						if (now > 1)
							now -= 2;
						odd.offer(now);
					} else {
						now -= 1;
						if (now == 0)
							continue;
						even.offer(now);
						break;
					}
				}
			}
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, day);
		}
	}
}