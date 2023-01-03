package com.ssafy.edu.pg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution__2_두큐합같게만들기 {

	public static void main(String args[]) throws Exception {
	}

	public int solution(int[] queue1, int[] queue2) {
		long sum1 = 0;
		long sum2 = 0;
		Queue<Long> q1 = new LinkedList<>();
		Queue<Long> q2 = new LinkedList<>();
		for (int i = 0; i < queue1.length; ++i) {
			q1.offer((long) queue1[i]);
			sum1 += queue1[i];
		}
		for (int i = 0; i < queue2.length; ++i) {
			q2.offer((long) queue2[i]);
			sum2 += queue2[i];
		}
		int cnt = 0;
		// 최대길이 = 2 * (q1 +q2)
		while (cnt < 2 * (q1.size() + q2.size()) && sum1 != sum2) {
			long tmp = 0;
			if (sum1 > sum2) {
				tmp = q1.poll();
				q2.offer(tmp);
				sum1 -= tmp;
				sum2 += tmp;
			} else {
				tmp = q2.poll();
				q1.offer(tmp);
				sum1 += tmp;
				sum2 -= tmp;
			}
			cnt++;
		}
		if (sum1 != sum2)
			return -1;
		return cnt;
	}
}