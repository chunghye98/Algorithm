import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visit;
	static List<Point> points;
	static int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌

	static int result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve() {
		for (Point p : points) {
			visit = new boolean[N][N];
			dfs(1, p.y, p.x, map[p.y][p.x], false);
		}
	}

	public static void dfs(int count, int y, int x, int height, boolean flag) {
		result = Math.max(result, count);

		visit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = dxy[i][0] + y;
			int nx = dxy[i][1] + x;

			if (!isRange(ny, nx) || visit[ny][nx])
				continue;

			if (map[ny][nx] < height) {
				dfs(count + 1, ny, nx, map[ny][nx], flag);
			} else if (!flag && map[ny][nx] - K < height) {
				dfs(count + 1, ny, nx, height - 1, true);

			}
		}
		visit[y][x] = false;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);

		map = new int[N][N];

		points = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				max = Math.max(max, map[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == max) {
					points.add(new Point(i, j));
				}
			}
		}

		result = Integer.MIN_VALUE;
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}