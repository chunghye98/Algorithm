import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int[][] map;
	static boolean[] dessert;
	static int result;
	static int[][] dxy = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

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
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				backtracking(i, j, 0, new MyPoint(i, j), 0);
			}
		}
	}

	public static void backtracking(int y, int x, int count, MyPoint start, int direction) {
		if(!isRange(y, x) || direction == 4) {
			return;
		}
		
		if (dessert[map[y][x]]) {
			if (y == start.y && x == start.x && count >= 4) {
				result = Math.max(result, count);
				return;
			}

			return;
		}
		
		dessert[map[y][x]] = true;
		int ny = y + dxy[direction][0];
		int nx = x + dxy[direction][1];

		backtracking(ny, nx, count + 1, start, direction);
		backtracking(ny, nx, count + 1, start, direction + 1);

		dessert[map[y][x]] = false;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		dessert = new boolean[101];
		map = new int[N][N];
		result = -1;

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}

class MyPoint {
	int y;
	int x;

	MyPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
}