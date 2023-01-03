package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2071_평균값2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = 10;
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			for (int i = 0; i < N; ++i) {
				sum += nums[i];
			}

			System.out.printf("#%d %.0f\n", t, 1.0 * sum / N);

		}

	}

}
