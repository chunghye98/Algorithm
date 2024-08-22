import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visit;
	static int count;
	static int[] dy = { -1, 0, 1 }; // 위로 갈 수 있으면 가는 것이 제일 경로를 많이 만들 수 있다. 

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}
	
	public static void output() {
		System.out.println(count);
	}

	public static void solve() {

		// 행 검사
		for (int i = 0; i < R; i++) {
			// 경로가 만들어지면 count++
			if (dfs(i, 0)) {
				count++;
			}
		}
	}

	public static boolean dfs(int y, int x) {
		if (x == C - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int ny = dy[i] + y;
			int nx = 1 + x;

			if (!isRange(ny, nx) || isBuilding(ny, nx) || visit[ny][nx]) {
				continue;
			}

			visit[ny][nx] = true;

			if (dfs(ny, nx)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}

	public static boolean isBuilding(int y, int x) {
		return map[y][x] == 'x';
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
}