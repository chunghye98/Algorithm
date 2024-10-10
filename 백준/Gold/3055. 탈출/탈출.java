import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;
	static char[][] map;
	static MyPoint dochiStart;
	static MyPoint end;
	static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Queue<MyPoint> water = new ArrayDeque<>();

	static int result;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void output() {
		if (result == -1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
	}

	private static void solve() {
		Queue<MyPoint> dochi = new ArrayDeque<>();
		dochi.add(dochiStart);

		int time = 0;
		while (!dochi.isEmpty()) {
			time++;

			// 물 이동
			int wSize = water.size(); // 한 턴에 이 크기만큼 water 확장
			for (int i = 0; i < wSize; i++) {
				MyPoint cur = water.poll();

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dxy[d][0];
					int nx = cur.x + dxy[d][1];

					if (isRange(ny, nx)) {
						continue;
					}

					if (map[ny][nx] == 'S' || map[ny][nx] == '.') {
						water.add(new MyPoint(ny, nx));
						map[ny][nx] = '*';
					}
				}
			}

			int dSize = dochi.size();
			for (int i = 0; i < dSize; i++) {
				MyPoint cur = dochi.poll();

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dxy[d][0];
					int nx = cur.x + dxy[d][1];

					if (isRange(ny, nx)) {
						continue;
					}

					if (map[ny][nx] == '.') {
						dochi.add(new MyPoint(ny, nx));
						map[ny][nx] = 'S';
					} else if (map[ny][nx] == 'D') {
						result = time;
						return;
					}
				}
			}
		}
		result = -1;
	}

	private static boolean isRange(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			char[] temps = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temps[j];
				if (map[i][j] == 'S') {
					dochiStart = new MyPoint(i, j);
				} else if (map[i][j] == '*') {
					water.add(new MyPoint(i, j)); // 여러 곳에서 시작 가능
				} else if (map[i][j] == 'D') {
					end = new MyPoint(i, j);
				}
			}
		}

		result = 0;
	}

	static class MyPoint {
		int y;
		int x;

		public MyPoint(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}