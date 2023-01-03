package com.ssafy.edu.magicSqure;

public class FourMagicSqure extends MagicSqure {
	public FourMagicSqure() {
		this(4);
	}

	public FourMagicSqure(int n) {
		super(n);
	}

	@Override
	public void make() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (((i == 0 || i == n - 1) && (j != 0 && j != n - 1))
						|| (j == 0 || j == n - 1) && ((i != 0 && i != n - 1))) {
					magic[i][j] = (n * n) - (i * n + j);
				} else {
					magic[i][j] = i * n + j + 1;
				}

//				if ((0 <= i && i < n / 4) || (n / 4 * 3 <= i && i < n)) {// 양쪽 가
//					if (n / 4 <= j && j < n / 4 * 3) {// 중앙
//						magic[i][j] = n * n - (i * n + j);
//					}
//				} else {
//					if ((0 <= j && j < n / 4) || (n / 4 * 3 <= j && j < n)) {
//						if (n / 4 <= i && i < n / 4 * 3) {// 중앙
//							magic[i][j] = n * n - (i * n + j);
//						}
//					}
//				}
			}
		}
	}
}
