package com.ssafy.edu.pg;

class Solution__2_행렬테두리회전하기 {

	public static void main(String args[]) throws Exception {
	}
	
	class Solution {
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        int num=1;
	        int[][] arr= new int[rows+1][columns+1];
	        for(int i=1;i<=rows;++i){
	            for(int j=1;j<=columns;++j){
	                arr[i][j]=num++;
	            }
	        }
	        
	        for(int i=0;i<queries.length;++i){
	            int y1=queries[i][0];
	            int x1=queries[i][1];
	            int y2=queries[i][2];
	            int x2=queries[i][3];
	            
	            int min=arr[y1][x1];
	            int tmp=arr[y1][x1];
	            
	            for(int j=y1;j<y2;++j){
	                min=Math.min(min,arr[j][x1]);
	                arr[j][x1]=arr[j+1][x1];
	            }
	            
	            for(int j=x1;j<x2;++j){
	                min=Math.min(min,arr[y2][j]);
	                arr[y2][j]=arr[y2][j+1];
	            }
	            
	            for(int j=y2;j>y1;--j){
	                min=Math.min(min,arr[j][x2]);
	                arr[j][x2]=arr[j-1][x2];
	            }
	            
	            for(int j=x2;j>x1;--j){
	                min=Math.min(min,arr[y1][j]);
	                arr[y1][j]=arr[y1][j-1];
	            }
	            arr[y1][x1+1]=tmp;
	            answer[i]=min;
	        }
	        return answer;
	    }
	}
}