package com.ssafy.edu.magicSqure;

import java.util.Scanner;

public class MagicSqureTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MagicSqure odd = null;
		// Factory Pattern
		if (n % 2 == 1) {
			odd = new OddMagicSqure(n);
		} else if (n % 4 == 0) {
			odd = new FourMagicSqure(n);
		}
		odd.make();
		odd.print();
		sc.close();
	}
}
