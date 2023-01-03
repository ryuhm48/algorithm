package com.ssafy.edu.beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1094_막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int X = Integer.parseInt(br.readLine());
		int size = 64;
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.offer(64);
		// 가장 작은 막대를 꺼냄
		while (!pq.isEmpty() && size != X) {
			int now = pq.poll();
			int tmp = now / 2;
			size -= tmp;
			pq.offer(tmp);
			// 자른 막대가 X와 같다면 종료
			if (size == X) {
				break;
			} else if (size < X) {
				// 자른 막대가 X보다 작다면
				size += tmp;
				pq.offer(tmp);
			}
		}
		answer = pq.size();
		sb.append(answer + "\n");
		System.out.println(sb.toString());
	}
}
