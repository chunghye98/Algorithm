import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int R;
	static int C;
	static char[][] board;
	static boolean[] alphabet = new boolean[26];
	static int[][] dxy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int result = 1;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		sb.append(result).append("\n");
		System.out.println(sb);
	}
	
	public static void solve() {
		dfs(0, 0, 0);
	}

	public static void dfs(int y, int x, int count) {
		if (alphabet[board[y][x] - 'A']) {
			result = Math.max(result, count);
			return;
		}

		alphabet[board[y][x] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int ny = dxy[i][0] + y;
			int nx = dxy[i][1] + x;
			
			if(!isRange(ny, nx)) {
				continue;
			}
			
			dfs(ny, nx, count +1);
		}
		alphabet[board[y][x] - 'A'] = false;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}

	public static void init() throws Exception {
		String[] temp = br.readLine().split(" ");
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);

		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
	}

}