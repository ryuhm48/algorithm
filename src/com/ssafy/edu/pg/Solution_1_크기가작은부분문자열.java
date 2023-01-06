package com.ssafy.edu.pg;

class Solution__ {

	public static void main(String args[]) throws Exception {
		class Solution {
			public int solution(String t, String p) {
				int answer = 0;
				int len=p.length();
				int size=0;
				long intP=Long.parseLong(p);
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<t.length();++i){
					sb.append(t.charAt(i));
					size++;

					if(size>=len){
						long tmp = Long.parseLong(sb.toString());
						if(tmp<=intP){
							answer++;
						}
						size--;
						StringBuilder temp=new StringBuilder();
						temp.append(sb.substring(1));
						sb=temp;
					}
				}
				return answer;
			}
		}
	}
}