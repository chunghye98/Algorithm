import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static Point doyeon;
	static int count;
	static int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		map = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];
				if (line[j] == 'I') {
					doyeon = new Point(i, j);
				}
			}
		}
	}

	private static void solve() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(doyeon);
		visit[doyeon.y][doyeon.x] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int cy = cur.y;
			int cx = cur.x;

			for (int i = 0; i < 4; i++) {
				int ny = dyx[i][0] + cy;
				int nx = dyx[i][1] + cx;

				if (!isRange(ny, nx) || visit[ny][nx] || map[ny][nx] == 'X') {
					continue;
				}

				visit[ny][nx] = true;
				queue.add(new Point(ny, nx));

				if (map[ny][nx] == 'P') {
					count++;
				}
			}
		}
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

	private static void output() {
		if (count == 0) {
			System.out.println("TT");
		}else {
			System.out.println(count);
		}
	}
}