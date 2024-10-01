import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int testcase;
	static int N;
	static int K;
	static int[] volumes, costs;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}

	private static void output(int t) {
		sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
	}

	public static void solve() {
		for (int i = 1; i <= N; i++) { // 아이템
			for (int j = 1; j <= K; j++) { // 남은 용량
				if(volumes[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], costs[i] + dp[i - 1][j - volumes[i]]);
				}
			}
		}
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);

		volumes = new int[N + 1];
		costs = new int[N + 1];
		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			inputs = br.readLine().split(" ");

			volumes[i] = Integer.parseInt(inputs[0]);
			costs[i] = Integer.parseInt(inputs[1]);
		}
	}
}