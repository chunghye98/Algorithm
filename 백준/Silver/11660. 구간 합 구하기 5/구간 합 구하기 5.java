import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[][] map;
	static int[][] sumMap;
	static List<Target> targets = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void output() {
		System.out.println(sb);
	}

	private static void solve() {
		makeSumMap();
		findPartSum();
	}

	private static void findPartSum() {
		int result = 0;
		for (Target target : targets) {
			int endY = target.endY;
			int endX = target.endX;
			int startY = target.startY;
			int startX = target.startX;

			if(startY == 0 && startX != 0) {
				result = sumMap[endY][endX] - sumMap[endY][startX - 1];
			}else if(startY != 0 && startX == 0) {
				result = sumMap[endY][endX] - sumMap[startY - 1][endX];
			} else if(startY == 0 && startX == 0) {
				result = sumMap[endY][endX];
			}else {
				result = sumMap[endY][endX] - sumMap[startY - 1][endX] - sumMap[endY][startX - 1] + sumMap[startY - 1][startX - 1];
			}

			sb.append(result).append("\n");
		}
	}

	private static void makeSumMap() {
		sumMap[0][0] = map[0][0];
		for (int i = 1; i < n; i++) {
			sumMap[0][i] = sumMap[0][i - 1] + map[0][i];
			sumMap[i][0] = sumMap[i - 1][0] + map[i][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				sumMap[i][j] = sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1] + map[i][j];
			}
		}
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		map = new int[n][n];
		sumMap = new int[n][n];

		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[j][i] = Integer.parseInt(inputs[j]);
			}
		}

		for (int i = 0; i < m; i++) {
			inputs = br.readLine().split(" ");
			int x1 = Integer.parseInt(inputs[0]) - 1;
			int y1 = Integer.parseInt(inputs[1]) - 1;
			int x2 = Integer.parseInt(inputs[2]) - 1;
			int y2 = Integer.parseInt(inputs[3]) - 1;
			targets.add(new Target(y2, x2, y1, x1));
		}
	}
}

class Target {
	int endY;
	int endX;
	int startY;
	int startX;

	Target(int endY, int endX, int startY, int startX) {
		this.endY = endY;
		this.endX = endX;
		this.startY = startY;
		this.startX = startX;
	}
}