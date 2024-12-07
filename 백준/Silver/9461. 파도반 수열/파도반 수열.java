import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			solve();
		}
		System.out.println(sb);
	}

	private static void solve() throws IOException {
		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		sb.append(dp[n]).append("\n");
	}
}