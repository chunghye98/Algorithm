import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static int[][] synergy;
	static int result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			init();
			comb(0, 0, new int[n / 2]);
			output(testCase);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void comb(int cnt, int start, int[] selectedA) {
		if (cnt == n / 2) {
			int[] selectedB = findOther(selectedA);
			calculate(selectedA, selectedB);
			return;
		}

		for (int i = start; i < n; i++) {
			selectedA[cnt] = i;
			comb(cnt + 1, i + 1, selectedA);
		}
	}

	public static void calculate(int[] selectedA, int[] selectedB) {
		int sumA = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				sumA += synergy[selectedA[i]][selectedA[j]] + synergy[selectedA[j]][selectedA[i]];
			}
		}
		int sumB = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				sumB += synergy[selectedB[i]][selectedB[j]] + synergy[selectedB[j]][selectedB[i]];
			}
		}
		result = Math.min(result, Math.abs(sumA - sumB));
	}

	public static int[] findOther(int[] selectedA) {
		boolean[] selected = new boolean[n];
		for (int i = 0; i < selectedA.length; i++) {
			selected[selectedA[i]] = true;
		}

		int[] selectedB = new int[n / 2];
		int index = 0;

		for (int i = 0; i < selected.length; i++) {
			if (!selected[i]) {
				selectedB[index++] = i;
			}
		}
		return selectedB;
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		synergy = new int[n][n];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				synergy[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}