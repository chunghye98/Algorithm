import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static char[][] map;
	static int[][] numbers;
	static boolean[][] visit;
	static int result;
	static int[][] dxy = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } }; // 11시부터
																													// 시계방향

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			init();
			solve();
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve() {
		findNumbers();
		countZeroRange();
		countPositiveRange();
	}

	public static void countPositiveRange() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					continue;
				}

				if (numbers[i][j] > 0) {
					result++;
				}
			}
		}
	}

	public static void countZeroRange() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '*' || visit[i][j]) {
					continue;
				}

				if (numbers[i][j] == 0) {
					bfs(i, j);
					result++;
				}
			}
		}
	}

	public static void bfs(int y, int x) {
		Queue<MyPoint> queue = new ArrayDeque<>();
		visit[y][x] = true;
		queue.add(new MyPoint(y, x));

		while (!queue.isEmpty()) {
			MyPoint cur = queue.poll();
			int cy = cur.y;
			int cx = cur.x;

			for (int i = 0; i < 8; i++) {
				int ny = dxy[i][0] + cy;
				int nx = dxy[i][1] + cx;

				if (!isRange(ny, nx) || visit[ny][nx]) {
					continue;
				}

				visit[ny][nx] = true;

				if (numbers[ny][nx] != 0) {
					continue;
				}

				queue.add(new MyPoint(ny, nx));
			}
		}
	}

	public static void findNumbers() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '*') {
					visit[i][j] = true;
					continue;
				}

				numbers[i][j] = countStar(i, j);
			}
		}
	}

	public static int countStar(int y, int x) {
		int count = 0;
		for (int k = 0; k < 8; k++) {
			int ny = dxy[k][0] + y;
			int nx = dxy[k][1] + x;

			if (!isRange(ny, nx)) {
				continue;
			}

			if (map[ny][nx] == '*') {
				count++;
			}
		}

		return count;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		numbers = new int[N][N];
		result = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
}

class MyPoint {
	int y;
	int x;

	public MyPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
}