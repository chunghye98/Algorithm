import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int M;
	static boolean[][] map;
	static List<Point> persons;
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

		for (int k = 1; k <= N + 1; k++) {
			findByAllCenters(k);
		}
	}
	
	public static void findByAllCenters(int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int count = findPersonInCircle(i, j, k);
				int cost = (int) Math.pow(k, 2) + (int) Math.pow(k - 1, 2);
				int profit = count * M - cost;

				if (profit >= 0) {
					result = Math.max(result, count);
				}

			}
		}
	}
	
	public static int findPersonInCircle(int y, int x, int k) {
		int count = 0;
		for (Point p : persons) {
			if (Math.abs(p.x - x) + Math.abs(p.y - y) < k) {
				count++;
			}
		}
		return count;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		result = Integer.MIN_VALUE;

		map = new boolean[N][N];
		persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = inputs[j].equals("0") ? false : true;
				if (map[i][j]) {
					persons.add(new Point(i, j));
				}
			}
		}
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