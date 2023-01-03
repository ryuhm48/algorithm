package com.ssafy.edu.swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;

class Solution_8382_방향전환 {
	static int answer;
	static int N;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int[][][] visit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
//		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// start
			answer = 0;
			int difX = Math.abs(x1 - x2);
			int difY = Math.abs(y1 - y2);
			int mx = Math.max(difX, difY);
			answer = mx * 2;
			if (difX % 2 != difY % 2) {
				answer--;
			}
//			x1 += 100;
//			y1 += 100;
//			x2 += 100;
//			y2 += 100;
//			Queue<int[]> q = new LinkedList<>();
//			q.offer(new int[] { x1, y1, 0 });
//			q.offer(new int[] { x1, y1, 1 });
//			
//			visit = new int[201][201][2];
//			visit[y1][x1][0]=1;
//			visit[y1][x1][1]=1;
//			
//			int flg = 1;
//			while (!q.isEmpty() && flg == 1) {
//				int[] now = q.poll();
//				for (int dir = 0; dir < 4; ++dir) {
//					if ((dir % 2 != now[2])) {
//						continue;
//					}
//					int ny = now[1] + dy[dir];
//					int nx = now[0] + dx[dir];
//					int not = (now[2] + 1) % 2;
//					if (ny < 0 || ny > 200 || nx < 0 || nx > 200)
//						continue;
//					if (visit[ny][nx][now[2]] != 0)
//						continue;
//					visit[ny][nx][now[2]] = visit[now[1]][now[0]][not] + 1;
//					q.offer(new int[] { nx, ny, not });
//					if (ax == x2 && ny == y2) {
//						answer = visit[ny][nx][now[2]]-1;
//						flg = 0;
//						break;
//					}
//				}
//			}
			// end

			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}