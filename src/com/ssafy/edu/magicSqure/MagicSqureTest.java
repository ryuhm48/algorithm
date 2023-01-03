package com.ssafy.edu.magicSqure;

import java.util.Scanner;

public class MagicSqureTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MagicSqure odd = MagicFactory.factory(n);
		MagicFactory.print(odd);
		sc.close();
	}
}
