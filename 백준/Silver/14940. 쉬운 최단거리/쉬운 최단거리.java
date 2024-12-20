import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Point start;
	static int[][] map;
	static boolean[][] visit;
	static int[][] resultMap;
	static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		map = new int[N][M];
		visit = new boolean[N][M];
		resultMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				if(map[i][j] == 2) {
					start = new Point(i, j);
				}
			}
		}
	}

	private static void solve() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(start);
		visit[start.y][start.x] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int cy = cur.y;
			int cx = cur.x;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dxy[i][0];
				int nx = cx + dxy[i][1];

				if (isRange(ny, nx) && !visit[ny][nx] && map[ny][nx] != 0) {
					resultMap[ny][nx] = resultMap[cy][cx] + 1;
					visit[ny][nx] = true;
					queue.add(new Point(ny, nx));
				}
			}
		}
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	private static void output() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && resultMap[i][j] == 0) {
					sb.append("-1").append(" ");
					continue;
				}
				sb.append(resultMap[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}