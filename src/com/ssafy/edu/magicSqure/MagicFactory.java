package com.ssafy.edu.magicSqure;

public class MagicFactory {
	public static MagicSqure factory(int n) {
		MagicSqure odd = null;
		// Factory Pattern
		if (n % 2 == 1) {
			odd = new OddMagicSqure(n);// 부타자생
		} else if (n % 4 == 0) {
			odd = new FourMagicSqure(n);
		}
		return odd;
	}

	public static void print(MagicSqure odd) {// 부타자참
		odd.make();// 부메자호
		odd.print();
	}

}
