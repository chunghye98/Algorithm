import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1];
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j]);
			}
			dp[i] += 1;
		}

		System.out.println(dp[N]);
	}
}