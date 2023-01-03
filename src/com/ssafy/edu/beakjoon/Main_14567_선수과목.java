package com.ssafy.edu.beakjoon;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14567_선수과목 {
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static List<List<Integer>> list;
	static int[][] map;
	static int[] arr;
	static int[] visit;
	static int[] W;
	static int[] V;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new int[N + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visit[b]++;
		}

		// start
		Queue<Integer>q= new LinkedList<>();
		for(int i=1;i<N+1;++i) {
			if(visit[i]==0) {
				//시작위치에 추가
				q.offer(i);
			}
		}
		// end

		// 출력
		for (int i = 0; i < N; ++i) {
			System.out.print(+" ");
		}
	}
}
