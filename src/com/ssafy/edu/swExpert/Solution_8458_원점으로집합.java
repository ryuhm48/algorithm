package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.awt.*;

class Solution_8458_원점으로집합 {
	static int answer;
	static int N;
	static List<Long> odd;
	static List<Long> even;
	static Map<Long, Long> m;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p o= new c();
		System.out.println(o.c(4));
		int T;
		T = Integer.parseInt(br.readLine());
		odd = new ArrayList<>();
		even = new ArrayList<>();
		m = new HashMap<>();
		long n = 0;
		for (long i = 1; i < 1000000; ++i) {
			n = n + i;
			m.put(n, i);
			if (n % 2 == 0)
				even.add((long) n);
			else
				odd.add((long) n);
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int flg = -1;
			int zeroCnt = 0;
			int mx = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int num = Math.abs(a) + Math.abs(b);
				mx = Math.max(mx, num);
				if (num == 0) {
					zeroCnt++;
					mx = Math.max(mx, 2);
				}
				if (flg == -1) {
					flg = num % 2;
					continue;
				}
				if (num == 1)
					continue;
				if (num % 2 != flg) {
					System.out.printf("#%d %d\n", test_case, -1);
					flg = -1;
					break;
				}
			}
			// start
			if (flg == -1)
				continue;
			if (zeroCnt == N) {
				System.out.printf("#%d %d\n", test_case, 0);
				continue;
			}
			long idx = -1;
			if (flg == 0) {
				idx = m.get(lowerBound(even, mx));
			} else {
				idx = m.get(lowerBound(odd, mx));
			}

			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, idx);
		}
	}

	private static long lowerBound(List<Long> data, int target) {
		int begin = 0;
		int end = data.size();
		while (begin < end) {
			int mid = (begin + end) / 2;

			if (data.get(mid) >= target) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return data.get(end);
	}
	static class p{
		int c(int n) {
			if(n<=1)return n;
			return c(n-1)*c(n-2);
		}
	}
	static class c extends p{
		int c(int n) {
			if(n<=1)return n;
			return c(n-1)+c(n-3);
		}
	}
}