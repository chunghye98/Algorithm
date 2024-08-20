import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static int[][] map;
	static int result;

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
		calculateTotalSum(0, n, n / 2, n / 2);
	}

	public static void calculateTotalSum(int start, int end, int upY, int downY) {
		if (start - end == 1) {
			return;
		}

		calculateSum(start, end, upY, downY);

		calculateTotalSum(start + 1, end - 1, upY - 1, downY + 1);
	}

	public static void calculateSum(int start, int end, int upY, int downY) {
		for (int x = start; x < end; x++) {
			if (upY == downY) {
				result += map[upY][x];
				continue;
			}
			result += map[upY][x] + map[downY][x];
		}
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		result = 0;

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}