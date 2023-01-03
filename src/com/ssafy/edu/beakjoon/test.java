package com.ssafy.edu.beakjoon;

import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		int num=new Random().nextInt(2);
		try {
			System.out.println(num);
			int i=1/num;
			System.out.println("c2");
			return;
		}catch(Exception e) {

			System.out.println("c3");
		}
		finally {

			System.out.println("c4");
		}
		System.out.println("c5");
	}

}
