package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자 {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			// start
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int mx = -1;
			long answer = 0L;
			for (int i = N - 1; i >= 0; --i) {
				if (mx < arr[i]) {
					mx = arr[i];
				}
				answer += mx - arr[i];
			}
			// end
			System.out.printf("#%d %d\n", t, answer);
		}

	}
}
