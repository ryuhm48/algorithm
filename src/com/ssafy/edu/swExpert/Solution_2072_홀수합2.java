package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2072_홀수합2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
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
				if (nums[i] % 2 == 1)
					sum += nums[i];
			}

			System.out.println("#" + t + " " + sum);

		}

	}

}
