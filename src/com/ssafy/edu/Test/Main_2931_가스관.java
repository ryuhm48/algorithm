import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static point s, e;
	static int R, C;
	static int count;
	static point answer;
	static point block;
	static int[][] visit;
	static char[][] map;
	static char[] changeChar = { ' ', '|', '-', '+', '1', '2', '3', '4' };
	static int[][] canMove = { { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1, 2, 3 }, { 1, 2 }, { 0, 1 }, { 0, 3 },
			{ 2, 3 } };

	static class point {
		int x;
		int y;
		int useBlock;
		char block;

		point(int x, int y, int useBlock) {
			this.x = x;
			this.y = y;
			this.useBlock = useBlock;
		}

		point(int x, int y, int useBlock, char block) {
			this.x = x;
			this.y = y;
			this.useBlock = useBlock;
			this.block = block;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new int[R][C];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			for (int j = 0; j < C; ++j) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '.')
					continue;
				if (map[i][j] == 'M') {
					s = new point(j, i, 0);
				} else if (map[i][j] == 'Z') {
					e = new point(j, i, 1);
				} else {
					count++;
					if (map[i][j] == '+')
						count++;
				}
			}
		}
		// 0 1 2 3 4 5 6 7
		visit[s.y][s.x] = 1;
		func(s.x, s.y, 0, 0);

		sb.append((answer.y + 1) + " " + (answer.x + 1) + " " + answer.block + "\n");
		System.out.println(sb.toString());
	}

	private static void func(int x, int y, int useBlock, int cnt) {
		if (x == e.x && y == e.y) {
			// 블록 사용해야함
			if (useBlock != 1)
				return;
			// 모든 블록 사용해야함
			// +블록 두번 왔다갔다해야함
			if (count + 1 != cnt)
				return;

			answer = new point(block.x, block.y, block.useBlock, block.block);
			System.out.println((answer.y + 1) + " " + (answer.x + 1) + " " + answer.block);
			System.exit(0);
			return;
		}
		int num = changeMap(map[y][x]);

		for (int d = 0; d < canMove[num].length; ++d) {
			int dir = canMove[num][d];
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			int used = useBlock;
			if (nx < 0 || nx >= C || ny < 0 || ny >= R)
				continue;
			// +블록 두번 왔다갔다해야함
			if (visit[ny][nx] > 0) {
				if (map[ny][nx] != '+' || visit[ny][nx] == 2)
					continue;
			}
			// 블록사용
			if (map[ny][nx] == '.') {
				if (used > 0)
					continue;
				// 7개 블록 모두 사용해야함
				for (int i = 1; i < 8; ++i) {
					int tmpDir = (dir + 2) % 4;
					int flg = 0;
					// 시작방향에서 가능한지 확인
					for (int j = 0; j < canMove[i].length; ++j) {
						if (canMove[i][j] == tmpDir) {
							flg = 1;
							break;
						}
					}
					if (flg == 0)
						continue;
					visit[ny][nx]++;
					map[ny][nx] = changeChar[i];
					if (i == 3)
						count++;
					count++;
					block = new point(nx, ny, i, changeChar[i]);
					func(nx, ny, used + 1, cnt + 1);
					block = null;
					count--;
					if (i == 3)
						count--;
					map[ny][nx] = '.';
					visit[ny][nx]--;
				}
				continue;

			}
			// 블록없이 사용
			visit[ny][nx]++;
			func(nx, ny, used, cnt + 1);
			visit[ny][nx]--;
		}
	}

	private static int changeMap(char d) {
		int ret = 0;
		switch (d) {
		case '|':
			ret = 1;
			break;
		case '-':
			ret = 2;
			break;
		case '+':
			ret = 3;
			break;
		case '1':
			ret = 4;
			break;
		case '2':
			ret = 5;
			break;
		case '3':
			ret = 6;
			break;
		case '4':
			ret = 7;
			break;
		}
		return ret;
	}
}
