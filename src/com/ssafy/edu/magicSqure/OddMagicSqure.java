package com.ssafy.edu.magicSqure;

public class OddMagicSqure extends MagicSqure{
	public OddMagicSqure() {
		this(3);
	}

	public OddMagicSqure(int n) {
		super(n);
	}

	@Override
	public void make() {
		int c = n / 2;
		int r = 0;
		for (int i = 0; i < n * n; ++i) {
			magic[r][c] = i + 1;
			int nr = (r + n - 1) % n;
			int nc = (c + n - 1) % n;
			if (magic[nr][nc] != 0) {
				r = (r + n + 1) % n;
				continue;
			}
			r = nr;
			c = nc;
		}
	}
}
