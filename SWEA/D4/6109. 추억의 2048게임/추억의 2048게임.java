import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static String command;
	static int[][] map;

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
		sb.append("#").append(t).append("\n");
		for(int[] values : map) {
			for(int v : values) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}
	}

	public static void solve() {
		switch (command) {
			case "up":
				goUp();
				break;
			case "down":
				goDown();
				break;
			case "right":
				goRight();
				break;
			case "left":
				goLeft();
				break;
		}
	}

	public static void goUp() {
		for (int k = 0; k < n; k++) {
			moveZeroByUp();
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i - 1][j] == map[i][j]) {
					map[i - 1][j] *= 2;
					map[i][j] = 0;
				}
			}
			for (int k = 0; k < n; k++) {
				moveZeroByUp();
			}
		}
	}

	public static void goDown() {
		for (int k = 0; k < n; k++) {
			moveZeroByDown();
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (map[i + 1][j] == map[i][j]) {
					map[i + 1][j] *= 2;
					map[i][j] = 0;
				}
			}
			for (int k = 0; k < n; k++) {
				moveZeroByDown();
			}
		}
	}

	public static void goRight() {
		for (int k = 0; k < n; k++) {
			moveZeroByRight();
		}
		for (int j = n - 2; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				if (map[i][j + 1] == map[i][j]) {
					map[i][j + 1] *= 2;
					map[i][j] = 0;
				}
			}
			for (int k = 0; k < n; k++) {
				moveZeroByRight();
			}
		}
	}

	public static void goLeft() {
		for (int k = 0; k < n; k++) {
			moveZeroByLeft();
		}
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (map[i][j - 1] == map[i][j]) {
					map[i][j - 1] *= 2;
					map[i][j] = 0;
				}
			}
			for (int k = 0; k < n; k++) {
				moveZeroByLeft();
			}
		}
	}

	public static void moveZeroByUp() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i - 1][j] == 0) {
					swap(i - 1, j, i, j);
				}
			}
		}
	}

	public static void moveZeroByDown() {
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (map[i + 1][j] == 0) {
					swap(i + 1, j, i, j);
				}
			}
		}
	}

	public static void moveZeroByLeft() {
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (map[i][j - 1] == 0) {
					swap(i, j - 1, i, j);
				}
			}
		}
	}

	public static void moveZeroByRight() {
		for (int j = n-2; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				if (map[i][j + 1] == 0) {
					swap(i, j + 1, i, j);
				}
			}
		}
	}

	public static void swap(int by, int bx, int cy, int cx) {
		int temp = map[by][bx];
		map[by][bx] = map[cy][cx];
		map[cy][cx] = temp;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		command = inputs[1];

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}