package com.ssafy.edu.magicSqure;

public abstract class MagicSqure {
	protected int[][] magic;
	protected int n;

	public MagicSqure(int n) {
		super();
		this.n = n;
		magic = new int[n][n];
	}
	public abstract void make();

	public void print() {
		for (int[] r : magic) {
			for (int c : r) {
				System.out.printf("%d ", c);
			}
			System.out.println();
		}
	}
}
