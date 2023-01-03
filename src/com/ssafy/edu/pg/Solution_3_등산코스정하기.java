package com.ssafy.edu.pg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.awt.*;

class Solution_3_등산코스정하기 {
//	class node implements Comparable<node> {
//		int x;
//		int dir;
//		int st;
//
//		node(int x, int dir, int st) {
//			this.x = x;
//			this.dir = dir;
//			this.st = st;
//		}
//
//		node(int x, int dir) {
//			this.x = x;
//			this.dir = dir;
//		}
//
//		@Override
//		public int compareTo(node o) {
//			if (dir != o.dir)
//				return Integer.compare(dir, o.dir);
//			return Integer.compare(x, o.x);
//		}
//		@Override
//		public String toString() {
//			// TODO Auto-generated method stub
//			return super.toString();
//		}
//	}
//
//	static List<node>[] map;
//	static int[] dist;
//	static Set<Integer> s;
//	static Set<Integer> s2;
//	static int[] answer = new int[2];
//
//	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
//		map = new ArrayList[n + 1];
//		dist = new int[n + 1];
//		s = new HashSet<>();
//		s2 = new HashSet<>();
//
//		for (int i = 0; i < n + 1; ++i)
//			map[i] = new ArrayList<>();
//		for (int i = 0; i < paths.length; ++i) {
//			int u = paths[i][0];
//			int v = paths[i][1];
//			int d = paths[i][2];
//			map[u].add(new node(v, d));
//			map[v].add(new node(u, d));
//		}
//		PriorityQueue<node> pq = new PriorityQueue<>();
//		for (int i = 0; i < n + 1; ++i)
//			dist[i] = Integer.MAX_VALUE;
//		for (int i = 0; i < gates.length; ++i) {
//			pq.offer(new node(gates[i], 0, gates[i]));
//			dist[gates[i]] = 0;
//			s.add(gates[i]);
//		}
//		for (int i = 0; i < summits.length; ++i) {
//			s2.add(summits[i]);
//		}
//		answer[0] = Integer.MAX_VALUE;
//		answer[1] = Integer.MAX_VALUE;
//		while (!pq.isEmpty()) {
//			node now = pq.poll();
//
//			for (int i = 0; i < map[now.x].size(); ++i) {
//				node next = map[now.x].get(i);
//				// 다른 출발점 만남
//				if (now.st != next.x && s.contains(next.x))
//					continue;
//				// 산봉오리 만남
//				if (s2.contains(next.x)) {
//					// 최댓값계산
//					int dis = Math.max(next.dir, dist[now.x]);
//					if (answer[1] >= dis) {
//						if (answer[0] < next.x)
//							continue;
//						answer[0] = next.x;
//						answer[1] = dis;
//					}
//				}
//				dist[next.x] = Math.max(dist[now.x], next.dir);
//			}
//		}
//		return answer;
//	}
	// n 50000
	// path 200000
	// 시작위치~ 시작위치x 봉오리 하나 거치는 경우
	static class node implements Comparable<node> {
		int x;
		int dir;
		int st;

		node(int x, int dir, int st) {
			this.x = x;
			this.dir = dir;
			this.st = st;
		}

		node(int x, int dir) {
			this.x = x;
			this.dir = dir;
		}

		@Override
		public int compareTo(node o) {
			// if (dir != o.dir)
			return Integer.compare(dir, o.dir);
			// return Integer.compare(x, o.x);
		}

		@Override
		public String toString() {
			return x + " " + dir + " " + st;
		}
	}

	static List<node>[] map;
	static int[] dist;
	static Set<Integer> s;
	static Set<Integer> s2;
	static int[] answer = new int[2];

	static int[] p;
	static int[] f1;
	static int[] f2;
	static int[] mx;

	static int findp(int a) {
		if (p[a] == a)
			return a;
		return p[a] = findp(p[a]);
	}

	static boolean unionp(int a, int b, int val) {
		a = findp(a);
		b = findp(b);

		if (a == b)
			return false;
		// if(s.contains(a)==true &&s.contains(b)==true)return false;
		// if(s.contains(a)==true)p[b]=a;
		// else if(s.contains(b)==true)p[a]=b;
		// else
		if (a < b) {
			p[b] = a;
			if (f1[b] == 1 || f1[a] == 1) {
				f1[b] = 1;
				f1[a] = 1;
			}
			if (f2[b] == 1 || f2[a] == 1) {
				f2[b] = 1;
				f2[a] = 1;
			}
			mx[b] = Math.max(mx[b], val);
			mx[a] = Math.max(mx[a], val);
		} else {
			p[a] = b;
			if (f1[b] == 1 || f1[a] == 1) {
				f1[b] = 1;
				f1[a] = 1;
			}
			if (f2[b] == 1 || f2[a] == 1) {
				f2[b] = 1;
				f2[a] = 1;
			}
			mx[b] = Math.max(mx[b], val);
			mx[a] = Math.max(mx[a], val);
		}
		return true;
	}

	static public int bfs(int st, int n, int val) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		int[] visit = new int[n + 1];
		visit[st] = 1;

		int ret = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int sz = 0; sz < size; ++sz) {
				int now = q.poll();
				for (int i = 0; i < map[now].size(); ++i) {
					int next = map[now].get(i).x;
					if (findp(now) != findp(next))
						continue;
					if (mx[next] > val)
						continue;
					if (visit[next] != 0)
						continue;
					if (s2.contains(next)) {
						ret = Math.min(ret, next);
						System.out.println(next);
					}
					visit[next] = 1;
					q.offer(next);
				}
			}
		}
		return ret;
	}

	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		p = new int[n + 1];
		f1 = new int[n + 1];
		f2 = new int[n + 1];
		mx = new int[n + 1];
		s = new HashSet<>();
		s2 = new HashSet<>();
		map = new ArrayList[n + 1];
		List<node> list = new ArrayList<>();
		PriorityQueue<node> pq = new PriorityQueue<>();

		for (int i = 0; i < n + 1; ++i)
			map[i] = new ArrayList<>();
		for (int i = 0; i < gates.length; ++i) {
			s.add(gates[i]);
			f1[gates[i]] = 1;
		}

		for (int i = 0; i < summits.length; ++i) {
			s2.add(summits[i]);
			f2[summits[i]] = 1;

		}

		for (int i = 0; i < paths.length; ++i) {
			int u = paths[i][0];
			int v = paths[i][1];
			int d = paths[i][2];
			map[u].add(new node(v, d));
			map[v].add(new node(u, d));
			pq.offer(new node(u, d, v));
		}

		for (int i = 0; i < n + 1; ++i)
			p[i] = i;

		answer[0] = Integer.MAX_VALUE;
		answer[1] = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            node now= pq.poll();
          if(unionp(now.x,now.st,now.dir)){
 
                // if(f1[findp(now.x)]==1 && f2[findp(now.st)]==1){         
                //     for (int i = 0; i < gates.length; ++i) {
                //         if(findp(gates[i])==findp(now.x)){
                //             System.out.println(now.x+" "+now.st+" "+gates[i]); 
                //             answer[0]=Math.min(answer[0],bfs(gates[i],n,mx[gates[i]]));          
                //             answer[1]=Math.min(answer[1],mx[findp(now.x)]);
                //             System.out.println(answer[0]+" "+answer[1]); 
                //         }
                //     }
                // }
            }
            
        }
        for(int i=1;i<n+1;++i){
            if(!s2.contains(i))continue;
            if(answer[1]<mx[i])continue;
            if(answer[1]==mx[i] && i>answer[0])continue;
            answer[1]=mx[i];
            answer[0]=i;
        }
                            System.out.println(Arrays.toString(p));   
                            System.out.println(Arrays.toString(mx));   
		return answer;
	}

	public static void main(String args[]) throws Exception {
//		solution(7, new int[][] { { 1, 2, 5 }, { 1, 4, 1 }, { 2, 3, 1 }, { 2, 6, 7 }, { 4, 5, 1 }, { 5, 6, 1 },
//				{ 6, 7, 1 } }, new int[] { 3, 7 }, new int[] { 1, 5 });
		solution(6, new int[][] { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4, 4 }, { 4, 5, 3 },
				{ 4, 6, 1 }, { 5, 6, 1 } }, new int[] { 1, 3 }, new int[] { 5 });
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Integer.parseInt(br.readLine());
//		Integer.parseInt(st.nextToken());
	}
}