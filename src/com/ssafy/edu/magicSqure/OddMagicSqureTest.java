package com.ssafy.edu.magicSqure;

import java.util.Scanner;

public class OddMagicSqureTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MagicSqure odd = new OddMagicSqure(n);
		odd.make();
		odd.print();
		sc.close();
	}
}
